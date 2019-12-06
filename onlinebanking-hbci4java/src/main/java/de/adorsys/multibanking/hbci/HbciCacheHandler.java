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

package de.adorsys.multibanking.hbci;

import de.adorsys.multibanking.domain.request.AbstractRequest;
import de.adorsys.multibanking.domain.response.AbstractResponse;
import lombok.Getter;
import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@UtilityClass
public class HbciCacheHandler {

    @Getter
    private static Map<String, Map<String, String>> bpdCache = new ConcurrentHashMap<>();

    static HbciBpdUpdCallback setRequestBpdAndCreateCallback(AbstractRequest request) {
        String bankCode = Optional.ofNullable(request.getBank().getBankApiBankCode())
            .orElse(request.getBank().getBankCode());

        request.setHbciBPD(bpdCache.get(bankCode));
        return new HbciBpdUpdCallback(bankCode, bpdCache);
    }

    static void updateUpd(HbciBpdUpdCallback bpdUpdHbciCallback, AbstractResponse response) {
        Optional.ofNullable(bpdUpdHbciCallback)
            .ifPresent(callback -> {
                response.setHbciUpd(callback.getUpd());
                response.setHbciSysId(callback.getSysId());
            });
    }

}
