/*
 * finAPI RESTful Services
 * finAPI RESTful Services
 *
 * OpenAPI spec version: v1.20.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Container for bank connection import parameters
 */
@ApiModel(description = "Container for bank connection import parameters")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class Body3 {
  @SerializedName("bankId")
  private Long bankId = null;

  @SerializedName("bankingUserId")
  private String bankingUserId = null;

  @SerializedName("bankingCustomerId")
  private String bankingCustomerId = null;

  @SerializedName("bankingPin")
  private String bankingPin = null;

  @SerializedName("storePin")
  private Boolean storePin = false;

  @SerializedName("name")
  private String name = null;

  @SerializedName("skipPositionsDownload")
  private Boolean skipPositionsDownload = false;

  @SerializedName("maxDaysForDownload")
  private Integer maxDaysForDownload = null;

  @SerializedName("accountTypeIds")
  private List<Long> accountTypeIds = new ArrayList<Long>();

  public Body3 bankId(Long bankId) {
    this.bankId = bankId;
    return this;
  }

   /**
   * Bank Identifier
   * @return bankId
  **/
  @ApiModelProperty(example = "null", required = true, value = "Bank Identifier")
  public Long getBankId() {
    return bankId;
  }

  public void setBankId(Long bankId) {
    this.bankId = bankId;
  }

  public Body3 bankingUserId(String bankingUserId) {
    this.bankingUserId = bankingUserId;
    return this;
  }

   /**
   * Online banking user ID credential. When importing the 'demo connection', you may leave this field unset.
   * @return bankingUserId
  **/
  @ApiModelProperty(example = "null", value = "Online banking user ID credential. When importing the 'demo connection', you may leave this field unset.")
  public String getBankingUserId() {
    return bankingUserId;
  }

  public void setBankingUserId(String bankingUserId) {
    this.bankingUserId = bankingUserId;
  }

  public Body3 bankingCustomerId(String bankingCustomerId) {
    this.bankingCustomerId = bankingCustomerId;
    return this;
  }

   /**
   * Online banking customer ID credential (for most banks this field can remain unset)
   * @return bankingCustomerId
  **/
  @ApiModelProperty(example = "null", value = "Online banking customer ID credential (for most banks this field can remain unset)")
  public String getBankingCustomerId() {
    return bankingCustomerId;
  }

  public void setBankingCustomerId(String bankingCustomerId) {
    this.bankingCustomerId = bankingCustomerId;
  }

  public Body3 bankingPin(String bankingPin) {
    this.bankingPin = bankingPin;
    return this;
  }

   /**
   * Online banking PIN. When importing the 'demo connection', you may leave this field unset.
   * @return bankingPin
  **/
  @ApiModelProperty(example = "null", value = "Online banking PIN. When importing the 'demo connection', you may leave this field unset.")
  public String getBankingPin() {
    return bankingPin;
  }

  public void setBankingPin(String bankingPin) {
    this.bankingPin = bankingPin;
  }

  public Body3 storePin(Boolean storePin) {
    this.storePin = storePin;
    return this;
  }

   /**
   * Whether to store the PIN. If the PIN is stored, it is not required to pass the PIN again when updating this bank connection or executing orders (like money transfers). Default is false.
   * @return storePin
  **/
  @ApiModelProperty(example = "null", value = "Whether to store the PIN. If the PIN is stored, it is not required to pass the PIN again when updating this bank connection or executing orders (like money transfers). Default is false.")
  public Boolean getStorePin() {
    return storePin;
  }

  public void setStorePin(Boolean storePin) {
    this.storePin = storePin;
  }

  public Body3 name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Custom name for the bank connection. Maximum length is 64. If you do not want to set a name, you can leave this field unset.
   * @return name
  **/
  @ApiModelProperty(example = "null", value = "Custom name for the bank connection. Maximum length is 64. If you do not want to set a name, you can leave this field unset.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Body3 skipPositionsDownload(Boolean skipPositionsDownload) {
    this.skipPositionsDownload = skipPositionsDownload;
    return this;
  }

   /**
   * Whether to skip the download of transactions and securities or not. If set to true, then finAPI will download just the accounts list with the accounts' information (like account name, number, holder, etc), as well as the accounts' balances (if possible), but skip the download of transactions and securities. Default is false.<br><br>NOTES:<br>&bull; If you skip the download of transactions and securities during an import or update, you can still download them on a later update (though you might not get all positions at a later point, because the date range in which the bank servers provide this data is usually limited). However, once finAPI has downloaded the transactions or securities for the first time, you will not be able to go back to skipping the download of transactions and securities! In other words: Once you make your first request with skipPositionsDownload=false for a certain bank connection, you will no longer be able to make a request with skipPositionsDownload=true for that same bank connection.<br>&bull; If this bank connection is updated via finAPI's automatic batch update, then transactions and security positions <u>will</u> be downloaded in any case!<br>&bull; For security accounts, skipping the downloading of the securities might result in the account's balance also not being downloaded.
   * @return skipPositionsDownload
  **/
  @ApiModelProperty(example = "null", value = "Whether to skip the download of transactions and securities or not. If set to true, then finAPI will download just the accounts list with the accounts' information (like account name, number, holder, etc), as well as the accounts' balances (if possible), but skip the download of transactions and securities. Default is false.<br><br>NOTES:<br>&bull; If you skip the download of transactions and securities during an import or update, you can still download them on a later update (though you might not get all positions at a later point, because the date range in which the bank servers provide this data is usually limited). However, once finAPI has downloaded the transactions or securities for the first time, you will not be able to go back to skipping the download of transactions and securities! In other words: Once you make your first request with skipPositionsDownload=false for a certain bank connection, you will no longer be able to make a request with skipPositionsDownload=true for that same bank connection.<br>&bull; If this bank connection is updated via finAPI's automatic batch update, then transactions and security positions <u>will</u> be downloaded in any case!<br>&bull; For security accounts, skipping the downloading of the securities might result in the account's balance also not being downloaded.")
  public Boolean getSkipPositionsDownload() {
    return skipPositionsDownload;
  }

  public void setSkipPositionsDownload(Boolean skipPositionsDownload) {
    this.skipPositionsDownload = skipPositionsDownload;
  }

  public Body3 maxDaysForDownload(Integer maxDaysForDownload) {
    this.maxDaysForDownload = maxDaysForDownload;
    return this;
  }

   /**
   * Use this parameter if you want to limit the date range for transactions download. The value depicts the number of days that finAPI will download transactions for, starting from - and including - today. For example, if you want to download only transactions from within the past 30 days (including today), then pass the value 30. The minimum allowed value is 14, the maximum value is 3650. You may also pass the value 0 though (which is also the default value when you do not specify this parameter), in which case there will be no limit to the transactions download and finAPI will try to get all transactions that it can. Please note that when you specify the parameter there is no guarantee that finAPI will actually download transactions for the entire given date range, as the bank servers may limit the date range on their own. Also note that this parameter only applies to transactions, not to security positions; finAPI will always download all positions that it can get. At last, please note that this parameter is ignored when importing the 'demo connection'.
   * @return maxDaysForDownload
  **/
  @ApiModelProperty(example = "null", value = "Use this parameter if you want to limit the date range for transactions download. The value depicts the number of days that finAPI will download transactions for, starting from - and including - today. For example, if you want to download only transactions from within the past 30 days (including today), then pass the value 30. The minimum allowed value is 14, the maximum value is 3650. You may also pass the value 0 though (which is also the default value when you do not specify this parameter), in which case there will be no limit to the transactions download and finAPI will try to get all transactions that it can. Please note that when you specify the parameter there is no guarantee that finAPI will actually download transactions for the entire given date range, as the bank servers may limit the date range on their own. Also note that this parameter only applies to transactions, not to security positions; finAPI will always download all positions that it can get. At last, please note that this parameter is ignored when importing the 'demo connection'.")
  public Integer getMaxDaysForDownload() {
    return maxDaysForDownload;
  }

  public void setMaxDaysForDownload(Integer maxDaysForDownload) {
    this.maxDaysForDownload = maxDaysForDownload;
  }

  public Body3 accountTypeIds(List<Long> accountTypeIds) {
    this.accountTypeIds = accountTypeIds;
    return this;
  }

  public Body3 addAccountTypeIdsItem(Long accountTypeIdsItem) {
    this.accountTypeIds.add(accountTypeIdsItem);
    return this;
  }

   /**
   * Whitelist of identifiers of finAPI account types that are considered for the import. Only accounts whose type matches with one of the given types will be imported. Note that when the bank connection does not contain any accounts of the given types, the import will fail with error code NO_ACCOUNTS_FOR_TYPE_LIST. If no whitelist is given, then all accounts will be imported.<br>1 = Checking,<br>2 = Savings,<br>3 = CreditCard,<br>4 = Security,<br>5 = Loan,<br>6 = Pocket (DEPRECATED; will not be returned for any account unless this type has explicitly been set via PATCH),<br>7 = Membership<br>
   * @return accountTypeIds
  **/
  @ApiModelProperty(example = "null", value = "Whitelist of identifiers of finAPI account types that are considered for the import. Only accounts whose type matches with one of the given types will be imported. Note that when the bank connection does not contain any accounts of the given types, the import will fail with error code NO_ACCOUNTS_FOR_TYPE_LIST. If no whitelist is given, then all accounts will be imported.<br>1 = Checking,<br>2 = Savings,<br>3 = CreditCard,<br>4 = Security,<br>5 = Loan,<br>6 = Pocket (DEPRECATED; will not be returned for any account unless this type has explicitly been set via PATCH),<br>7 = Membership<br>")
  public List<Long> getAccountTypeIds() {
    return accountTypeIds;
  }

  public void setAccountTypeIds(List<Long> accountTypeIds) {
    this.accountTypeIds = accountTypeIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body3 body3 = (Body3) o;
    return Objects.equals(this.bankId, body3.bankId) &&
        Objects.equals(this.bankingUserId, body3.bankingUserId) &&
        Objects.equals(this.bankingCustomerId, body3.bankingCustomerId) &&
        Objects.equals(this.bankingPin, body3.bankingPin) &&
        Objects.equals(this.storePin, body3.storePin) &&
        Objects.equals(this.name, body3.name) &&
        Objects.equals(this.skipPositionsDownload, body3.skipPositionsDownload) &&
        Objects.equals(this.maxDaysForDownload, body3.maxDaysForDownload) &&
        Objects.equals(this.accountTypeIds, body3.accountTypeIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bankId, bankingUserId, bankingCustomerId, bankingPin, storePin, name, skipPositionsDownload, maxDaysForDownload, accountTypeIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body3 {\n");
    
    sb.append("    bankId: ").append(toIndentedString(bankId)).append("\n");
    sb.append("    bankingUserId: ").append(toIndentedString(bankingUserId)).append("\n");
    sb.append("    bankingCustomerId: ").append(toIndentedString(bankingCustomerId)).append("\n");
    sb.append("    bankingPin: ").append(toIndentedString(bankingPin)).append("\n");
    sb.append("    storePin: ").append(toIndentedString(storePin)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    skipPositionsDownload: ").append(toIndentedString(skipPositionsDownload)).append("\n");
    sb.append("    maxDaysForDownload: ").append(toIndentedString(maxDaysForDownload)).append("\n");
    sb.append("    accountTypeIds: ").append(toIndentedString(accountTypeIds)).append("\n");
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

