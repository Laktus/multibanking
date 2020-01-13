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
import { Booking } from './booking';


export interface WrappedBooking { 
    accountNumber?: string;
    amount?: number;
    bankCode?: string;
    bankConnection?: string;
    booking?: Booking;
    creditorId?: string;
    custom?: { [key: string]: string; };
    cycle?: WrappedBooking.CycleEnum;
    email?: string;
    executionDate?: string;
    homepage?: string;
    hotline?: string;
    iban?: string;
    logo?: string;
    mainCategory?: string;
    mandateReference?: string;
    nextBookingDate?: string;
    otherAccount?: string;
    purpose?: string;
    referenceName?: string;
    ruleIds?: Array<string>;
    specification?: string;
    standingOrder?: boolean;
    subCategory?: string;
    usedRules?: Array<string>;
}
export namespace WrappedBooking {
    export type CycleEnum = 'WEEKLY' | 'MONTHLY' | 'TWO_MONTHLY' | 'QUARTERLY' | 'HALF_YEARLY' | 'YEARLY';
    export const CycleEnum = {
        WEEKLY: 'WEEKLY' as CycleEnum,
        MONTHLY: 'MONTHLY' as CycleEnum,
        TWOMONTHLY: 'TWO_MONTHLY' as CycleEnum,
        QUARTERLY: 'QUARTERLY' as CycleEnum,
        HALFYEARLY: 'HALF_YEARLY' as CycleEnum,
        YEARLY: 'YEARLY' as CycleEnum
    };
}
