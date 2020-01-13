/**
 * Multibanking REST Api
 * Use a bank code (blz) ending with X00 000 00 like 300 000 00 to run aggainst the mock backend. Find the mock backend at ${hostname}:10010
 *
 * OpenAPI spec version: 5.4.5-SNAPSHOT
 * Contact: age@adorsys.de
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
import { BankLoginSettingsTO } from './bankLoginSettingsTO';
import { Link } from './link';


export interface ResourceBankTO { 
    _links?: Array<Link>;
    bankApi?: ResourceBankTO.BankApiEnum;
    bankCode?: string;
    bankingUrl?: string;
    bic?: string;
    loginSettings?: BankLoginSettingsTO;
    name?: string;
}
export namespace ResourceBankTO {
    export type BankApiEnum = 'HBCI' | 'FIGO' | 'FINAPI' | 'XS2A' | 'FIGO_ALTERNATIVE' | 'ING';
    export const BankApiEnum = {
        HBCI: 'HBCI' as BankApiEnum,
        FIGO: 'FIGO' as BankApiEnum,
        FINAPI: 'FINAPI' as BankApiEnum,
        XS2A: 'XS2A' as BankApiEnum,
        FIGOALTERNATIVE: 'FIGO_ALTERNATIVE' as BankApiEnum,
        ING: 'ING' as BankApiEnum
    };
}
