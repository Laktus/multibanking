package de.adorsys.multibanking.domain.spi;

import de.adorsys.multibanking.domain.BankAccount;
import de.adorsys.multibanking.domain.BankApi;
import de.adorsys.multibanking.domain.BankApiUser;
import de.adorsys.multibanking.domain.request.TransactionRequest;
import de.adorsys.multibanking.domain.response.*;
import de.adorsys.multibanking.domain.transaction.AbstractScaPaymentTransaction;
import de.adorsys.multibanking.domain.transaction.LoadAccounts;
import de.adorsys.multibanking.domain.transaction.LoadBookings;
import de.adorsys.multibanking.domain.transaction.SubmitAuthorisationCode;

public interface OnlineBankingService {

    BankApi bankApi();

    boolean externalBankAccountRequired();

    boolean userRegistrationRequired();

    BankApiUser registerUser(String userId);

    void removeUser(BankApiUser bankApiUser);

    LoadAccountInformationResponse loadBankAccounts(TransactionRequest<LoadAccounts> loadAccountInformationRequest);

    void removeBankAccount(BankAccount bankAccount, BankApiUser bankApiUser);

    LoadBookingsResponse loadBookings(TransactionRequest<LoadBookings> loadBookingsRequest);

    boolean bankSupported(String bankCode);

    boolean bookingsCategorized();

    AuthorisationCodeResponse initiatePayment(TransactionRequest<AbstractScaPaymentTransaction> paymentRequest);

    <T extends AbstractResponse> SubmitAuthorizationCodeResponse submitAuthorizationCode(TransactionRequest<SubmitAuthorisationCode> submitPaymentRequest);

    StrongCustomerAuthorisable getStrongCustomerAuthorisation();
}
