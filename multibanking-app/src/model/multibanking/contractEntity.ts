/**
 * Multibanking REST Api
 * Use a bank code (blz) ending with X00 000 00 like 300 000 00 to run aggainst the mock backend. Find the mock backend at ${hostname}:10010
 *
 * OpenAPI spec version: 4.2.1-SNAPSHOT
 * Contact: age@adorsys.de
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


export interface ContractEntity { 
    accountId?: string;
    amount?: number;
    cancelled?: boolean;
    email?: string;
    homepage?: string;
    hotline?: string;
    id?: string;
    interval?: ContractEntity.IntervalEnum;
    logo?: string;
    mainCategory?: string;
    mandateReference?: string;
    provider?: string;
    specification?: string;
    subCategory?: string;
    userId?: string;
}
export namespace ContractEntity {
    export type IntervalEnum = 'WEEKLY' | 'TWO_WEEKLY' | 'MONTHLY' | 'TWO_MONTHLY' | 'QUARTERLY' | 'HALF_YEARLY' | 'YEARLY' | 'INVALID';
    export const IntervalEnum = {
        WEEKLY: 'WEEKLY' as IntervalEnum,
        TWOWEEKLY: 'TWO_WEEKLY' as IntervalEnum,
        MONTHLY: 'MONTHLY' as IntervalEnum,
        TWOMONTHLY: 'TWO_MONTHLY' as IntervalEnum,
        QUARTERLY: 'QUARTERLY' as IntervalEnum,
        HALFYEARLY: 'HALF_YEARLY' as IntervalEnum,
        YEARLY: 'YEARLY' as IntervalEnum,
        INVALID: 'INVALID' as IntervalEnum
    };
}
