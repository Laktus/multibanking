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
import { SinglePayment } from './singlePayment';
import { TanTransportType } from './tanTransportType';


export interface CreatePaymentRequest { 
    payment?: SinglePayment;
    pin?: string;
    tanTransportType?: TanTransportType;
}
