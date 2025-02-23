/*
 * Copyright 2018-2019 adorsys GmbH & Co KG
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.adorsys.multibanking.hbci.job;

import de.adorsys.multibanking.domain.Amount;
import de.adorsys.multibanking.domain.StandingOrder;
import de.adorsys.multibanking.domain.request.TransactionRequest;
import de.adorsys.multibanking.domain.response.StandingOrdersResponse;
import de.adorsys.multibanking.domain.transaction.LoadStandingOrders;
import de.adorsys.multibanking.hbci.HbciBpdCacheHolder;
import lombok.extern.slf4j.Slf4j;
import org.kapott.hbci.GV.GVDauerSEPAList;
import org.kapott.hbci.GV_Result.GVRDauerList;
import org.kapott.hbci.manager.HBCIUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Currency;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static de.adorsys.multibanking.domain.Frequency.*;

@Slf4j
public class LoadStandingOrdersJob extends ScaAwareJob<LoadStandingOrders, StandingOrdersResponse> {

    public LoadStandingOrdersJob(TransactionRequest<LoadStandingOrders> transactionRequest, HbciBpdCacheHolder bpdCacheHolder) {
        super(transactionRequest, bpdCacheHolder);
    }

    @Override
    GVDauerSEPAList createHbciJob() {
        GVDauerSEPAList hbciJob = new GVDauerSEPAList(dialog.getPassport());
        hbciJob.setParam("src", getHbciKonto());
        return hbciJob;
    }

    @Override
    String getHbciJobName() {
        return GVDauerSEPAList.getLowlevelName();
    }

    @Override
    public StandingOrdersResponse createJobResponse() {
        List<StandingOrder> standingOrders = ((GVRDauerList) getOrCreateHbciJob().getJobResult()).getEntries().stream()
            .map(dauerAuftrag -> {
                StandingOrder standingOrder = new StandingOrder();
                standingOrder.setCreditorAccount(dauerAuftrag.other.iban);
                standingOrder.setCreditorName(dauerAuftrag.other.name);
                standingOrder.setTransactionAmount(new Amount(Currency.getInstance(dauerAuftrag.value.getCurr()),
                    new BigDecimal(HBCIUtils.bigDecimal2String(dauerAuftrag.value.getBigDecimalValue()))));
                standingOrder.setRemittanceInformationUnstructured(dauerAuftrag.usage);
                standingOrder.setBankTransactionCode(dauerAuftrag.orderid);
                Optional.ofNullable(dauerAuftrag.firstdate).ifPresent(date ->
                    standingOrder.setStartDate(LocalDateTime.ofInstant(date.toInstant(), ZoneOffset.UTC).toLocalDate()));
                Optional.ofNullable(dauerAuftrag.lastdate).ifPresent(date ->
                    standingOrder.setEndDate(LocalDateTime.ofInstant(date.toInstant(), ZoneOffset.UTC).toLocalDate()));
                standingOrder.setDayOfExecution(dauerAuftrag.execday);
                standingOrder.setEndToEndId(dauerAuftrag.endToEndId);
                standingOrder.setPurposeCode(dauerAuftrag.purposecode);

                switch (dauerAuftrag.turnus) {
                    case 1:
                        standingOrder.setFrequency(MONTHLY);
                        break;
                    case 2:
                        standingOrder.setFrequency(TWO_MONTHLY);
                        break;
                    case 3:
                        standingOrder.setFrequency(QUARTERLY);
                        break;
                    case 6:
                        standingOrder.setFrequency(HALF_YEARLY);
                        break;
                    case 12:
                        standingOrder.setFrequency(YEARLY);
                        break;
                }

                return standingOrder;
            })
            .collect(Collectors.toList());

        return new StandingOrdersResponse(standingOrders);
    }

}
