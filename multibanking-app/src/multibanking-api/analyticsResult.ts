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
import { BookingGroup } from './bookingGroup';
import { ConfigStatus } from './configStatus';
import { WrappedBooking } from './wrappedBooking';


export interface AnalyticsResult { 
    bookingGroups?: Array<BookingGroup>;
    bookings?: Array<WrappedBooking>;
    rulesStatus?: ConfigStatus;
}
