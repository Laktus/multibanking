package hbci4java.job;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.AbstractScaTransaction;
import domain.Product;
import domain.TanChallenge;
import domain.request.SepaTransactionRequest;
import domain.request.SubmitAuthorizationCodeRequest;
import exception.HbciException;
import hbci4java.model.HbciCallback;
import hbci4java.model.HbciDialogRequest;
import hbci4java.model.HbciPassport;
import hbci4java.model.HbciTanSubmit;
import org.apache.commons.lang3.StringUtils;
import org.kapott.hbci.GV.AbstractHBCIJob;
import org.kapott.hbci.GV.AbstractSEPAGV;
import org.kapott.hbci.GV.GVTAN2Step;
import org.kapott.hbci.GV_Result.HBCIJobResult;
import org.kapott.hbci.manager.ChallengeInfo;
import org.kapott.hbci.manager.HBCIDialog;
import org.kapott.hbci.manager.HBCITwoStepMechanism;
import org.kapott.hbci.manager.HHDVersion;
import org.kapott.hbci.passport.PinTanPassport;
import org.kapott.hbci.status.HBCIExecStatus;
import org.kapott.hbci.structures.Konto;

import java.util.List;
import java.util.Optional;

import static hbci4java.model.HbciDialogFactory.createDialog;
import static hbci4java.model.HbciDialogFactory.createPassport;
import static org.kapott.hbci.manager.HBCIJobFactory.newJob;

public abstract class ScaRequiredJob {

    private static ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.findAndRegisterModules();
        return objectMapper;
    }

    public HbciTanSubmit requestAuthorizationCode(SepaTransactionRequest sepaTransactionRequest) {
        HbciTanSubmit hbciTanSubmit = new HbciTanSubmit();
        Optional.ofNullable(sepaTransactionRequest.getSepaTransaction())
                .ifPresent(sepaTransaction -> hbciTanSubmit.setOriginJobName(getHbciJobName(sepaTransaction.getTransactionType())));

        HbciCallback hbciCallback = new HbciCallback() {

            @Override
            public void tanChallengeCallback(String orderRef, String challenge, String challenge_hhd_uc,
                                             HHDVersion.Type type) {
                //needed later for submitAuthorizationCode
                hbciTanSubmit.setOrderRef(orderRef);
                if (challenge != null) {
                    hbciTanSubmit.setTanChallenge(TanChallenge.builder()
                            .title(challenge)
                            .data(challenge_hhd_uc)
                            .build());
                }
            }
        };

        HbciDialogRequest dialogRequest = HbciDialogRequest.builder()
                .bankCode(sepaTransactionRequest.getBankCode() != null ? sepaTransactionRequest.getBankCode() :
                        sepaTransactionRequest.getBankAccess().getBankCode())
                .customerId(sepaTransactionRequest.getBankAccess().getBankLogin())
                .login(sepaTransactionRequest.getBankAccess().getBankLogin2())
                .hbciPassportState(sepaTransactionRequest.getBankAccess().getHbciPassportState())
                .pin(sepaTransactionRequest.getPin())
                .callback(hbciCallback)
                .build();
        dialogRequest.setProduct(Optional.ofNullable(sepaTransactionRequest.getProduct())
                .map(product -> new Product(product.getName(), product.getVersion()))
                .orElse(null));
        dialogRequest.setBpd(sepaTransactionRequest.getBpd());

        HBCIDialog dialog = createDialog(null, dialogRequest);

        HBCITwoStepMechanism hbciTwoStepMechanism =
                dialog.getPassport().getBankTwostepMechanisms().get(sepaTransactionRequest.getTanTransportType().getId());
        if (hbciTwoStepMechanism == null)
            throw new HbciException("inavalid two stem mechanism: " + sepaTransactionRequest.getTanTransportType().getId());

        dialog.getPassport().setCurrentSecMechInfo(hbciTwoStepMechanism);

        AbstractSEPAGV sepagv = createSepaJob(sepaTransactionRequest.getSepaTransaction(), dialog.getPassport(), null);

        GVTAN2Step hktan = new GVTAN2Step(dialog.getPassport());
        hktan.setSegVersion(hbciTwoStepMechanism.getSegversion());

        if (hbciTwoStepMechanism.getProcess() == 1) {
            hbciTanSubmit.setSepaPain(hktanProcess1(hbciTwoStepMechanism, sepagv, hktan));
            dialog.addTask(hktan, false);
        } else {
            hktanProcess2(dialog, sepagv, getDebtorAccount(sepaTransactionRequest.getSepaTransaction(),
                    dialog.getPassport()), hktan);
        }

        if (dialog.getPassport().tanMediaNeeded()) {
            hktan.setParam("tanmedia", sepaTransactionRequest.getTanTransportType().getMedium());
        }

        HBCIExecStatus status = dialog.execute(false);
        if (!status.isOK()) {
            throw new HbciException(status.getDialogStatus().getErrorString());
        }

        hbciTanSubmit.setPassportState(new HbciPassport.State(dialog.getPassport()).toJson());
        hbciTanSubmit.setDialogId(dialog.getDialogID());
        hbciTanSubmit.setMsgNum(dialog.getMsgnum());
        hbciTanSubmit.setTanTransportType(sepaTransactionRequest.getTanTransportType());
        Optional.ofNullable(sepagv)
                .ifPresent(abstractSEPAGV -> hbciTanSubmit.setOriginSegVersion(abstractSEPAGV.getSegVersion()));

        return hbciTanSubmit;
    }

    public String hktanProcess1(HBCITwoStepMechanism hbciTwoStepMechanism, AbstractSEPAGV sepagv, GVTAN2Step hktan) {
        //1. Schritt: HKTAN <-> HITAN
        //2. Schritt: HKUEB <-> HIRMS zu HKUEB
        hktan.setParam("process", hbciTwoStepMechanism.getProcess());
        hktan.setParam("notlasttan", "N");
        hktan.setParam("orderhash", sepagv.createOrderHash(hbciTwoStepMechanism.getSegversion()));

        // wenn needchallengeklass gesetzt ist:
        if (StringUtils.equals(hbciTwoStepMechanism.getNeedchallengeklass(), "J")) {
            ChallengeInfo cinfo = ChallengeInfo.getInstance();
            cinfo.applyParams(sepagv, hktan, hbciTwoStepMechanism);
        }

        return sepagv.getPainXml();
    }

    public void hktanProcess2(HBCIDialog dialog, AbstractSEPAGV sepagv, Konto orderAccount, GVTAN2Step hktan) {
        //Schritt 1: HKUEB und HKTAN <-> HITAN
        //Schritt 2: HKTAN <-> HITAN und HIRMS zu HIUEB
        hktan.setParam("process", "4");
        hktan.setParam("orderaccount", orderAccount);

        Optional<List<AbstractHBCIJob>> messages = Optional.ofNullable(sepagv)
                .map(abstractSEPAGV -> dialog.addTask(abstractSEPAGV));

        if (messages.isPresent()) {
            messages.get().add(hktan);
        } else {
            dialog.addTask(hktan);
        }
    }

    public String sumbitAuthorizationCode(SubmitAuthorizationCodeRequest submitAuthorizationCodeRequest) {
        HbciTanSubmit hbciTanSubmit;
        if (submitAuthorizationCodeRequest.getTanSubmit() instanceof HbciTanSubmit) {
            hbciTanSubmit = (HbciTanSubmit) submitAuthorizationCodeRequest.getTanSubmit();
        } else {
            hbciTanSubmit = deserializeTanSubmit((byte[]) submitAuthorizationCodeRequest.getTanSubmit());
        }

        HbciPassport.State state = HbciPassport.State.readJson(hbciTanSubmit.getPassportState());
        HbciPassport hbciPassport = createPassport(state.hbciVersion, state.blz, state.customerId, state.userId,
                state.hbciProduct,
                new HbciCallback() {

                    @Override
                    public String needTAN() {
                        return submitAuthorizationCodeRequest.getTan();
                    }
                });
        state.apply(hbciPassport);
        hbciPassport.setPIN(submitAuthorizationCodeRequest.getPin());

        HBCITwoStepMechanism hbciTwoStepMechanism =
                hbciPassport.getBankTwostepMechanisms().get(hbciTanSubmit.getTanTransportType().getId());
        hbciPassport.setCurrentSecMechInfo(hbciTwoStepMechanism);

        HBCIDialog hbciDialog = new HBCIDialog(hbciPassport, hbciTanSubmit.getDialogId(), hbciTanSubmit.getMsgNum());
        AbstractHBCIJob paymentGV;

        if (hbciTwoStepMechanism.getProcess() == 1) {
            paymentGV = submitProcess1(submitAuthorizationCodeRequest.getSepaTransaction(), hbciTanSubmit, hbciPassport,
                    hbciDialog);
        } else {
            paymentGV = submitProcess2(hbciTanSubmit, hbciDialog);
        }

        HBCIExecStatus status = hbciDialog.execute(true);
        if (!status.isOK()) {
            throw new HbciException(status.getDialogStatus().getErrorString());
        } else {
            return orderIdFromJobResult(paymentGV.getJobResult());
        }
    }

    private AbstractHBCIJob submitProcess1(AbstractScaTransaction transaction, HbciTanSubmit hbciTanSubmit, HbciPassport
            hbciPassport, HBCIDialog hbciDialog) {
        //1. Schritt: HKTAN <-> HITAN
        //2. Schritt: HKUEB <-> HIRMS zu HKUEB
        AbstractHBCIJob uebSEPAJob = createSepaJob(transaction, hbciPassport, hbciTanSubmit.getSepaPain());
        hbciDialog.addTask(uebSEPAJob);
        return uebSEPAJob;
    }

    public AbstractHBCIJob submitProcess2(HbciTanSubmit hbciTanSubmit, HBCIDialog hbciDialog) {
        //Schritt 1: HKUEB und HKTAN <-> HITAN
        //Schritt 2: HKTAN <-> HITAN und HIRMS zu HIUEB
        AbstractHBCIJob originJob = Optional.ofNullable(hbciTanSubmit.getOriginJobName())
                .map(s -> {
                    AbstractHBCIJob result = newJob(hbciTanSubmit.getOriginJobName(), hbciDialog.getPassport());
                    result.setSegVersion(hbciTanSubmit.getOriginSegVersion());
                    return result;
                }).orElse(null);

        GVTAN2Step hktan = new GVTAN2Step(hbciDialog.getPassport());
        hktan.setOriginJob(originJob);
        hktan.setParam("orderref", hbciTanSubmit.getOrderRef());
        hktan.setParam("process", "2");
        hktan.setParam("notlasttan", "N");
        hbciDialog.addTask(hktan, false);
        return originJob;
    }

    private HbciTanSubmit deserializeTanSubmit(byte[] data) {
        try {
            return objectMapper().readValue(data, HbciTanSubmit.class);
        } catch (Exception e) {
            throw new IllegalStateException("Could not deserialize HbciTanSubmit", e);
        }
    }

    Konto getDebtorAccount(AbstractScaTransaction sepaTransaction, PinTanPassport passport) {
        return Optional.ofNullable(sepaTransaction.getDebtorBankAccount())
                .map(bankAccount -> {
                    Konto konto = passport.findAccountByAccountNumber(bankAccount.getAccountNumber());
                    konto.iban = bankAccount.getIban();
                    konto.bic = bankAccount.getBic();
                    return konto;
                })
                .orElse(null);
    }

    abstract String getHbciJobName(AbstractScaTransaction.TransactionType paymentType);

    abstract String orderIdFromJobResult(HBCIJobResult jobResult);

    abstract AbstractSEPAGV createSepaJob(AbstractScaTransaction sepaTransaction, PinTanPassport passport,
                                          String sepaPain);
}
