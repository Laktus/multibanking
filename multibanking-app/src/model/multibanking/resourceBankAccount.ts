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
import { BankAccountBalance } from './bankAccountBalance';
import { Link } from './link';


export interface ResourceBankAccount {
    /**
     * Account number
     */
    accountNumber?: string;
    bankAccessId?: string;
    /**
     * Bank account balance
     */
    bankAccountBalance?: BankAccountBalance;
    /**
     * Bank name
     */
    bankName?: string;
    /**
     * Bank identification code
     */
    bic?: string;
    /**
     * Bank code
     */
    blz?: string;
    /**
     * ISO-2 country of this bank account
     */
    country?: string;
    /**
     * Currency of this bank account
     */
    currency?: string;
    /**
     * International bank account number
     */
    iban: string;
    id?: string;
    /**
     * Last Synchronisation date
     */
    lastSync?: Date;
    links?: Array<Link>;
    /**
     * Name of this bank account
     */
    name?: string;
    /**
     * Name of the account owner
     */
    owner?: string;
    /**
     * Categorization rules version
     */
    rulesVersion?: string;
    /**
     * Synchronisation status
     */
    syncStatus?: ResourceBankAccount.SyncStatusEnum;
    /**
     * Type of this bank account
     */
    type?: ResourceBankAccount.TypeEnum;
    userId?: string;
}
export namespace ResourceBankAccount {
    export type SyncStatusEnum = 'PENDING' | 'SYNC' | 'READY';
    export const SyncStatusEnum = {
        PENDING: 'PENDING' as SyncStatusEnum,
        SYNC: 'SYNC' as SyncStatusEnum,
        READY: 'READY' as SyncStatusEnum
    }
    export type TypeEnum = 'GIRO' | 'SAVINGS' | 'FIXEDTERMDEPOSIT' | 'DEPOT' | 'LOAN' | 'CREDITCARD' | 'BUIILDINGSAVING' | 'INSURANCE' | 'UNKNOWN';
    export const TypeEnum = {
        GIRO: 'GIRO' as TypeEnum,
        SAVINGS: 'SAVINGS' as TypeEnum,
        FIXEDTERMDEPOSIT: 'FIXEDTERMDEPOSIT' as TypeEnum,
        DEPOT: 'DEPOT' as TypeEnum,
        LOAN: 'LOAN' as TypeEnum,
        CREDITCARD: 'CREDITCARD' as TypeEnum,
        BUIILDINGSAVING: 'BUIILDINGSAVING' as TypeEnum,
        INSURANCE: 'INSURANCE' as TypeEnum,
        UNKNOWN: 'UNKNOWN' as TypeEnum
    }
}
