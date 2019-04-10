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
import { BankAccount } from './bankAccount';


export interface PaymentEntity { 
    amount?: number;
    createdDateTime?: Date;
    currency?: string;
    debtorBankAccount?: BankAccount;
    id?: string;
    orderId?: string;
    paymentId?: string;
    product?: string;
    purpose?: string;
    rawData?: string;
    receiver?: string;
    receiverAccountCurrency?: string;
    receiverAccountNumber?: string;
    receiverBankCode?: string;
    receiverBic?: string;
    receiverIban?: string;
    tanSubmitExternal?: any;
    transactionType?: PaymentEntity.TransactionTypeEnum;
    userId?: string;
}
export namespace PaymentEntity {
    export type TransactionTypeEnum = 'SINGLE_PAYMENT' | 'FOREIGN_PAYMENT' | 'FUTURE_SINGLE_PAYMENT' | 'FUTURE_SINGLE_PAYMENT_DELETE' | 'BULK_PAYMENT' | 'FUTURE_BULK_PAYMENT' | 'FUTURE_BULK_PAYMENT_DELETE' | 'STANDING_ORDER' | 'STANDING_ORDER_DELETE' | 'RAW_SEPA' | 'TAN_REQUEST' | 'DEDICATED_CONSENT';
    export const TransactionTypeEnum = {
        SINGLEPAYMENT: 'SINGLE_PAYMENT' as TransactionTypeEnum,
        FOREIGNPAYMENT: 'FOREIGN_PAYMENT' as TransactionTypeEnum,
        FUTURESINGLEPAYMENT: 'FUTURE_SINGLE_PAYMENT' as TransactionTypeEnum,
        FUTURESINGLEPAYMENTDELETE: 'FUTURE_SINGLE_PAYMENT_DELETE' as TransactionTypeEnum,
        BULKPAYMENT: 'BULK_PAYMENT' as TransactionTypeEnum,
        FUTUREBULKPAYMENT: 'FUTURE_BULK_PAYMENT' as TransactionTypeEnum,
        FUTUREBULKPAYMENTDELETE: 'FUTURE_BULK_PAYMENT_DELETE' as TransactionTypeEnum,
        STANDINGORDER: 'STANDING_ORDER' as TransactionTypeEnum,
        STANDINGORDERDELETE: 'STANDING_ORDER_DELETE' as TransactionTypeEnum,
        RAWSEPA: 'RAW_SEPA' as TransactionTypeEnum,
        TANREQUEST: 'TAN_REQUEST' as TransactionTypeEnum,
        DEDICATEDCONSENT: 'DEDICATED_CONSENT' as TransactionTypeEnum
    };
}
