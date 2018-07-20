/**
 * Multibanking REST Api
 * Use a bank code (blz) ending with X00 000 00 like 300 000 00 to run aggainst the mock backend. Find the mock backend at ${hostname}:10010
 *
 * OpenAPI spec version: 4.1.2-SNAPSHOT
 * Contact: age@adorsys.de
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
import { BankLoginSettings } from './bankLoginSettings';


export interface BankEntity {
    bankApi?: BankEntity.BankApiEnum;
    bankCode?: string;
    bic?: string;
    blzHbci?: string;
    id?: string;
    loginSettings?: BankLoginSettings;
    name?: string;
    searchIndex?: Array<string>;
}
export namespace BankEntity {
    export type BankApiEnum = 'HBCI' | 'FIGO' | 'FINAPI' | 'MOCK' | 'FIGO_ALTERNATIVE' | 'SCREEN_SCRAPPING';
    export const BankApiEnum = {
        HBCI: 'HBCI' as BankApiEnum,
        FIGO: 'FIGO' as BankApiEnum,
        FINAPI: 'FINAPI' as BankApiEnum,
        MOCK: 'MOCK' as BankApiEnum,
        FIGOALTERNATIVE: 'FIGO_ALTERNATIVE' as BankApiEnum,
        SCREENSCRAPPING: 'SCREEN_SCRAPPING' as BankApiEnum
    }
}
