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


export interface Rule {
    creditorId?: string;
    custom?: { [key: string]: string; };
    email?: string;
    expression?: string;
    homepage?: string;
    hotline?: string;
    incoming?: boolean;
    logo?: string;
    mainCategory?: string;
    order?: number;
    receiver?: string;
    ruleId?: string;
    similarityMatchType?: Rule.SimilarityMatchTypeEnum;
    specification?: string;
    stop?: boolean;
    subCategory?: string;
}
export namespace Rule {
    export type SimilarityMatchTypeEnum = 'IBAN' | 'REFERENCE_NAME' | 'PURPOSE' | 'CUSTOM';
    export const SimilarityMatchTypeEnum = {
        IBAN: 'IBAN' as SimilarityMatchTypeEnum,
        REFERENCENAME: 'REFERENCE_NAME' as SimilarityMatchTypeEnum,
        PURPOSE: 'PURPOSE' as SimilarityMatchTypeEnum,
        CUSTOM: 'CUSTOM' as SimilarityMatchTypeEnum
    }
}
