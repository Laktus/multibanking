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
import { BankAccount } from './bankAccount';
import { Link } from './link';


export interface ResourceSinglePaymentEntity { 
    _links?: Array<Link>;
    amount?: number;
    createdDateTime?: Date;
    currency?: string;
    id?: string;
    instantPayment?: boolean;
    orderId?: string;
    paymentId?: string;
    psuAccount?: BankAccount;
    purpose?: string;
    purposecode?: string;
    receiver?: string;
    receiverAccountCurrency?: string;
    receiverAccountNumber?: string;
    receiverBankCode?: string;
    receiverBic?: string;
    receiverIban?: string;
    submittedTime?: Date;
    tanSubmitExternal?: any;
    transactionType?: ResourceSinglePaymentEntity.TransactionTypeEnum;
    transfer?: boolean;
    userId?: string;
}
export namespace ResourceSinglePaymentEntity {
    export type TransactionTypeEnum = 'TRANSFER_PAYMENT' | 'SINGLE_PAYMENT' | 'INSTANT_PAYMENT' | 'FOREIGN_PAYMENT' | 'FUTURE_SINGLE_PAYMENT' | 'FUTURE_SINGLE_PAYMENT_DELETE' | 'BULK_PAYMENT' | 'FUTURE_BULK_PAYMENT' | 'FUTURE_BULK_PAYMENT_DELETE' | 'STANDING_ORDER' | 'STANDING_ORDER_DELETE' | 'RAW_SEPA' | 'TAN_REQUEST' | 'LOAD_BANKACCOUNTS' | 'LOAD_BALANCES' | 'LOAD_TRANSACTIONS' | 'LOAD_STANDING_ORDERS' | 'GET_PAYMENT_STATUS';
    export const TransactionTypeEnum = {
        TRANSFERPAYMENT: 'TRANSFER_PAYMENT' as TransactionTypeEnum,
        SINGLEPAYMENT: 'SINGLE_PAYMENT' as TransactionTypeEnum,
        INSTANTPAYMENT: 'INSTANT_PAYMENT' as TransactionTypeEnum,
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
        LOADBANKACCOUNTS: 'LOAD_BANKACCOUNTS' as TransactionTypeEnum,
        LOADBALANCES: 'LOAD_BALANCES' as TransactionTypeEnum,
        LOADTRANSACTIONS: 'LOAD_TRANSACTIONS' as TransactionTypeEnum,
        LOADSTANDINGORDERS: 'LOAD_STANDING_ORDERS' as TransactionTypeEnum,
        GETPAYMENTSTATUS: 'GET_PAYMENT_STATUS' as TransactionTypeEnum
    };
}
