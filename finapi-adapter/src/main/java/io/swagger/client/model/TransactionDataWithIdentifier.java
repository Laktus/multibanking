/*
 * finAPI RESTful Services
 * finAPI RESTful Services
 *
 * OpenAPI spec version: v1.46.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Data of transaction for categorization
 */
@ApiModel(description = "Data of transaction for categorization")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-14T19:12:52.919Z")
public class TransactionDataWithIdentifier {
  @SerializedName("accountTypeId")
  private Long accountTypeId = null;

  @SerializedName("amount")
  private BigDecimal amount = null;

  @SerializedName("purpose")
  private String purpose = null;

  @SerializedName("counterpart")
  private String counterpart = null;

  @SerializedName("counterpartIban")
  private String counterpartIban = null;

  @SerializedName("counterpartAccountNumber")
  private String counterpartAccountNumber = null;

  @SerializedName("counterpartBlz")
  private String counterpartBlz = null;

  @SerializedName("counterpartBic")
  private String counterpartBic = null;

  @SerializedName("mcCode")
  private String mcCode = null;

  @SerializedName("transactionId")
  private String transactionId = null;

  public TransactionDataWithIdentifier accountTypeId(Long accountTypeId) {
    this.accountTypeId = accountTypeId;
    return this;
  }

   /**
   * Identifier of account type.&lt;br/&gt;&lt;br/&gt;1 &#x3D; Checking,&lt;br/&gt;2 &#x3D; Savings,&lt;br/&gt;3 &#x3D; CreditCard,&lt;br/&gt;4 &#x3D; Security,&lt;br/&gt;5 &#x3D; Loan,&lt;br/&gt;6 &#x3D; Pocket (DEPRECATED; will not be returned for any account unless this type has explicitly been set via PATCH),&lt;br/&gt;7 &#x3D; Membership,&lt;br/&gt;8 &#x3D; Bausparen&lt;br/&gt;&lt;br/&gt;
   * minimum: 1
   * maximum: 7
   * @return accountTypeId
  **/
  @ApiModelProperty(required = true, value = "Identifier of account type.<br/><br/>1 = Checking,<br/>2 = Savings,<br/>3 = CreditCard,<br/>4 = Security,<br/>5 = Loan,<br/>6 = Pocket (DEPRECATED; will not be returned for any account unless this type has explicitly been set via PATCH),<br/>7 = Membership,<br/>8 = Bausparen<br/><br/>")
  public Long getAccountTypeId() {
    return accountTypeId;
  }

  public void setAccountTypeId(Long accountTypeId) {
    this.accountTypeId = accountTypeId;
  }

  public TransactionDataWithIdentifier amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Amount
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "Amount")
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public TransactionDataWithIdentifier purpose(String purpose) {
    this.purpose = purpose;
    return this;
  }

   /**
   * Purpose. Any symbols are allowed. Maximum length is 2000. Default value: null.
   * @return purpose
  **/
  @ApiModelProperty(value = "Purpose. Any symbols are allowed. Maximum length is 2000. Default value: null.")
  public String getPurpose() {
    return purpose;
  }

  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }

  public TransactionDataWithIdentifier counterpart(String counterpart) {
    this.counterpart = counterpart;
    return this;
  }

   /**
   * Counterpart. Any symbols are allowed. Maximum length is 80. Default value: null.
   * @return counterpart
  **/
  @ApiModelProperty(value = "Counterpart. Any symbols are allowed. Maximum length is 80. Default value: null.")
  public String getCounterpart() {
    return counterpart;
  }

  public void setCounterpart(String counterpart) {
    this.counterpart = counterpart;
  }

  public TransactionDataWithIdentifier counterpartIban(String counterpartIban) {
    this.counterpartIban = counterpartIban;
    return this;
  }

   /**
   * Counterpart IBAN. Default value: null.
   * @return counterpartIban
  **/
  @ApiModelProperty(value = "Counterpart IBAN. Default value: null.")
  public String getCounterpartIban() {
    return counterpartIban;
  }

  public void setCounterpartIban(String counterpartIban) {
    this.counterpartIban = counterpartIban;
  }

  public TransactionDataWithIdentifier counterpartAccountNumber(String counterpartAccountNumber) {
    this.counterpartAccountNumber = counterpartAccountNumber;
    return this;
  }

   /**
   * Counterpart account number. Default value: null.
   * @return counterpartAccountNumber
  **/
  @ApiModelProperty(value = "Counterpart account number. Default value: null.")
  public String getCounterpartAccountNumber() {
    return counterpartAccountNumber;
  }

  public void setCounterpartAccountNumber(String counterpartAccountNumber) {
    this.counterpartAccountNumber = counterpartAccountNumber;
  }

  public TransactionDataWithIdentifier counterpartBlz(String counterpartBlz) {
    this.counterpartBlz = counterpartBlz;
    return this;
  }

   /**
   * Counterpart BLZ. Default value: null.
   * @return counterpartBlz
  **/
  @ApiModelProperty(value = "Counterpart BLZ. Default value: null.")
  public String getCounterpartBlz() {
    return counterpartBlz;
  }

  public void setCounterpartBlz(String counterpartBlz) {
    this.counterpartBlz = counterpartBlz;
  }

  public TransactionDataWithIdentifier counterpartBic(String counterpartBic) {
    this.counterpartBic = counterpartBic;
    return this;
  }

   /**
   * Counterpart BIC. Default value: null.
   * @return counterpartBic
  **/
  @ApiModelProperty(value = "Counterpart BIC. Default value: null.")
  public String getCounterpartBic() {
    return counterpartBic;
  }

  public void setCounterpartBic(String counterpartBic) {
    this.counterpartBic = counterpartBic;
  }

  public TransactionDataWithIdentifier mcCode(String mcCode) {
    this.mcCode = mcCode;
    return this;
  }

   /**
   * Merchant category code (for credit card transactions only). Default value: null. NOTE: This field is currently not regarded.
   * @return mcCode
  **/
  @ApiModelProperty(value = "Merchant category code (for credit card transactions only). Default value: null. NOTE: This field is currently not regarded.")
  public String getMcCode() {
    return mcCode;
  }

  public void setMcCode(String mcCode) {
    this.mcCode = mcCode;
  }

  public TransactionDataWithIdentifier transactionId(String transactionId) {
    this.transactionId = transactionId;
    return this;
  }

   /**
   * Identifier of transaction. This can be any arbitrary string that will be passed back in the response so that you can map the results to the given transactions. Note that the identifier must be unique within the given list of transactions.
   * @return transactionId
  **/
  @ApiModelProperty(required = true, value = "Identifier of transaction. This can be any arbitrary string that will be passed back in the response so that you can map the results to the given transactions. Note that the identifier must be unique within the given list of transactions.")
  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionDataWithIdentifier transactionDataWithIdentifier = (TransactionDataWithIdentifier) o;
    return Objects.equals(this.accountTypeId, transactionDataWithIdentifier.accountTypeId) &&
        Objects.equals(this.amount, transactionDataWithIdentifier.amount) &&
        Objects.equals(this.purpose, transactionDataWithIdentifier.purpose) &&
        Objects.equals(this.counterpart, transactionDataWithIdentifier.counterpart) &&
        Objects.equals(this.counterpartIban, transactionDataWithIdentifier.counterpartIban) &&
        Objects.equals(this.counterpartAccountNumber, transactionDataWithIdentifier.counterpartAccountNumber) &&
        Objects.equals(this.counterpartBlz, transactionDataWithIdentifier.counterpartBlz) &&
        Objects.equals(this.counterpartBic, transactionDataWithIdentifier.counterpartBic) &&
        Objects.equals(this.mcCode, transactionDataWithIdentifier.mcCode) &&
        Objects.equals(this.transactionId, transactionDataWithIdentifier.transactionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountTypeId, amount, purpose, counterpart, counterpartIban, counterpartAccountNumber, counterpartBlz, counterpartBic, mcCode, transactionId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionDataWithIdentifier {\n");
    
    sb.append("    accountTypeId: ").append(toIndentedString(accountTypeId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    purpose: ").append(toIndentedString(purpose)).append("\n");
    sb.append("    counterpart: ").append(toIndentedString(counterpart)).append("\n");
    sb.append("    counterpartIban: ").append(toIndentedString(counterpartIban)).append("\n");
    sb.append("    counterpartAccountNumber: ").append(toIndentedString(counterpartAccountNumber)).append("\n");
    sb.append("    counterpartBlz: ").append(toIndentedString(counterpartBlz)).append("\n");
    sb.append("    counterpartBic: ").append(toIndentedString(counterpartBic)).append("\n");
    sb.append("    mcCode: ").append(toIndentedString(mcCode)).append("\n");
    sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

