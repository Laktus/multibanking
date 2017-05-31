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
 * Container for a bank&#39;s data
 */
@ApiModel(description = "Container for a bank's data")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-17T14:26:47.047Z")
public class InlineResponse2005Bank {
  @SerializedName("id")
  private Long id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("loginHint")
  private String loginHint = null;

  @SerializedName("bic")
  private String bic = null;

  @SerializedName("blz")
  private String blz = null;

  @SerializedName("blzs")
  private List<String> blzs = new ArrayList<String>();

  @SerializedName("loginFieldUserId")
  private String loginFieldUserId = null;

  @SerializedName("loginFieldCustomerId")
  private String loginFieldCustomerId = null;

  @SerializedName("loginFieldPin")
  private String loginFieldPin = null;

  @SerializedName("isSupported")
  private Boolean isSupported = false;

  /**
   * Gets or Sets supportedDataSources
   */
  public enum SupportedDataSourcesEnum {
    @SerializedName("WEB_SCRAPER")
    WEB_SCRAPER("WEB_SCRAPER"),
    
    @SerializedName("FINTS_SERVER")
    FINTS_SERVER("FINTS_SERVER");

    private String value;

    SupportedDataSourcesEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("supportedDataSources")
  private List<SupportedDataSourcesEnum> supportedDataSources = new ArrayList<SupportedDataSourcesEnum>();

  public InlineResponse2005Bank id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Bank identifier
   * @return id
  **/
  @ApiModelProperty(example = "null", required = true, value = "Bank identifier")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public InlineResponse2005Bank name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of bank
   * @return name
  **/
  @ApiModelProperty(example = "null", required = true, value = "Name of bank")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public InlineResponse2005Bank loginHint(String loginHint) {
    this.loginHint = loginHint;
    return this;
  }

   /**
   * Login hint. Contains a German message for the user that explains what kind of credentials are expected.<br><br>Please note that it is strongly recommended to always show the login hint to the user if there is one, as the credentials that finAPI requires for the bank might be different to the credentials that the user knows from the bank's website.<br><br>Also note that the contents of this field should always be interpreted as HTML, as the text might contain HTML tags for highlighted words, paragraphs, etc.
   * @return loginHint
  **/
  @ApiModelProperty(example = "null", value = "Login hint. Contains a German message for the user that explains what kind of credentials are expected.<br><br>Please note that it is strongly recommended to always show the login hint to the user if there is one, as the credentials that finAPI requires for the bank might be different to the credentials that the user knows from the bank's website.<br><br>Also note that the contents of this field should always be interpreted as HTML, as the text might contain HTML tags for highlighted words, paragraphs, etc.")
  public String getLoginHint() {
    return loginHint;
  }

  public void setLoginHint(String loginHint) {
    this.loginHint = loginHint;
  }

  public InlineResponse2005Bank bic(String bic) {
    this.bic = bic;
    return this;
  }

   /**
   * BIC of bank
   * @return bic
  **/
  @ApiModelProperty(example = "null", value = "BIC of bank")
  public String getBic() {
    return bic;
  }

  public void setBic(String bic) {
    this.bic = bic;
  }

  public InlineResponse2005Bank blz(String blz) {
    this.blz = blz;
    return this;
  }

   /**
   * BLZ of bank
   * @return blz
  **/
  @ApiModelProperty(example = "null", required = true, value = "BLZ of bank")
  public String getBlz() {
    return blz;
  }

  public void setBlz(String blz) {
    this.blz = blz;
  }

  public InlineResponse2005Bank blzs(List<String> blzs) {
    this.blzs = blzs;
    return this;
  }

  public InlineResponse2005Bank addBlzsItem(String blzsItem) {
    this.blzs.add(blzsItem);
    return this;
  }

   /**
   * List of BLZs that belong to this bank. NOTE: This field is deprecated and will be removed at some point. Please refer to field 'blz' instead.
   * @return blzs
  **/
  @ApiModelProperty(example = "null", required = true, value = "List of BLZs that belong to this bank. NOTE: This field is deprecated and will be removed at some point. Please refer to field 'blz' instead.")
  public List<String> getBlzs() {
    return blzs;
  }

  public void setBlzs(List<String> blzs) {
    this.blzs = blzs;
  }

  public InlineResponse2005Bank loginFieldUserId(String loginFieldUserId) {
    this.loginFieldUserId = loginFieldUserId;
    return this;
  }

   /**
   * Label for the user ID login field, as it is called on the bank's website (e.g. \"Nutzerkennung\"). If this field is set (i.e. not null) then you should prompt your users to enter the required data in a text field which you can label with this field's value.
   * @return loginFieldUserId
  **/
  @ApiModelProperty(example = "null", value = "Label for the user ID login field, as it is called on the bank's website (e.g. \"Nutzerkennung\"). If this field is set (i.e. not null) then you should prompt your users to enter the required data in a text field which you can label with this field's value.")
  public String getLoginFieldUserId() {
    return loginFieldUserId;
  }

  public void setLoginFieldUserId(String loginFieldUserId) {
    this.loginFieldUserId = loginFieldUserId;
  }

  public InlineResponse2005Bank loginFieldCustomerId(String loginFieldCustomerId) {
    this.loginFieldCustomerId = loginFieldCustomerId;
    return this;
  }

   /**
   * Label for the customer ID login field, as it is called on the bank's website (e.g. \"Kundennummer\"). If this field is set (i.e. not null) then you should prompt your users to enter the required data in a text field which you can label with this field's value.
   * @return loginFieldCustomerId
  **/
  @ApiModelProperty(example = "null", value = "Label for the customer ID login field, as it is called on the bank's website (e.g. \"Kundennummer\"). If this field is set (i.e. not null) then you should prompt your users to enter the required data in a text field which you can label with this field's value.")
  public String getLoginFieldCustomerId() {
    return loginFieldCustomerId;
  }

  public void setLoginFieldCustomerId(String loginFieldCustomerId) {
    this.loginFieldCustomerId = loginFieldCustomerId;
  }

  public InlineResponse2005Bank loginFieldPin(String loginFieldPin) {
    this.loginFieldPin = loginFieldPin;
    return this;
  }

   /**
   * Label for the PIN field, as it is called on the bank's website (mostly \"PIN\"). If this field is set (i.e. not null) then you should prompt your users to enter the required data in a text field which you can label with this field's value.
   * @return loginFieldPin
  **/
  @ApiModelProperty(example = "null", value = "Label for the PIN field, as it is called on the bank's website (mostly \"PIN\"). If this field is set (i.e. not null) then you should prompt your users to enter the required data in a text field which you can label with this field's value.")
  public String getLoginFieldPin() {
    return loginFieldPin;
  }

  public void setLoginFieldPin(String loginFieldPin) {
    this.loginFieldPin = loginFieldPin;
  }

  public InlineResponse2005Bank isSupported(Boolean isSupported) {
    this.isSupported = isSupported;
    return this;
  }

   /**
   * Whether this bank is supported by finAPI, i.e. whether you can import/update a bank connection of this bank.
   * @return isSupported
  **/
  @ApiModelProperty(example = "null", required = true, value = "Whether this bank is supported by finAPI, i.e. whether you can import/update a bank connection of this bank.")
  public Boolean getIsSupported() {
    return isSupported;
  }

  public void setIsSupported(Boolean isSupported) {
    this.isSupported = isSupported;
  }

  public InlineResponse2005Bank supportedDataSources(List<SupportedDataSourcesEnum> supportedDataSources) {
    this.supportedDataSources = supportedDataSources;
    return this;
  }

  public InlineResponse2005Bank addSupportedDataSourcesItem(SupportedDataSourcesEnum supportedDataSourcesItem) {
    this.supportedDataSources.add(supportedDataSourcesItem);
    return this;
  }

   /**
   * List of the data sources that finAPI will use for data download for this bank. Possible values:<br><br> - FINTS_SERVER - means that finAPI will download data via the bank's FinTS interface.<br> - WEB_SCRAPER - means that finAPI will parse data from the bank's online banking website.<br><br>Note that this list will be empty for non-supported banks. Note also that web scraping might be disabled for your client (see GET /clientConfiguration). When this is the case, then finAPI will not use the web scraper for data download, and if the web scraper is the only supported data source of this bank, then finAPI will not allow to download any data for this bank at all (for details, see POST /bankConnections/import and POST /bankConnections/update).
   * @return supportedDataSources
  **/
  @ApiModelProperty(example = "null", required = true, value = "List of the data sources that finAPI will use for data download for this bank. Possible values:<br><br> - FINTS_SERVER - means that finAPI will download data via the bank's FinTS interface.<br> - WEB_SCRAPER - means that finAPI will parse data from the bank's online banking website.<br><br>Note that this list will be empty for non-supported banks. Note also that web scraping might be disabled for your client (see GET /clientConfiguration). When this is the case, then finAPI will not use the web scraper for data download, and if the web scraper is the only supported data source of this bank, then finAPI will not allow to download any data for this bank at all (for details, see POST /bankConnections/import and POST /bankConnections/update).")
  public List<SupportedDataSourcesEnum> getSupportedDataSources() {
    return supportedDataSources;
  }

  public void setSupportedDataSources(List<SupportedDataSourcesEnum> supportedDataSources) {
    this.supportedDataSources = supportedDataSources;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2005Bank inlineResponse2005Bank = (InlineResponse2005Bank) o;
    return Objects.equals(this.id, inlineResponse2005Bank.id) &&
        Objects.equals(this.name, inlineResponse2005Bank.name) &&
        Objects.equals(this.loginHint, inlineResponse2005Bank.loginHint) &&
        Objects.equals(this.bic, inlineResponse2005Bank.bic) &&
        Objects.equals(this.blz, inlineResponse2005Bank.blz) &&
        Objects.equals(this.blzs, inlineResponse2005Bank.blzs) &&
        Objects.equals(this.loginFieldUserId, inlineResponse2005Bank.loginFieldUserId) &&
        Objects.equals(this.loginFieldCustomerId, inlineResponse2005Bank.loginFieldCustomerId) &&
        Objects.equals(this.loginFieldPin, inlineResponse2005Bank.loginFieldPin) &&
        Objects.equals(this.isSupported, inlineResponse2005Bank.isSupported) &&
        Objects.equals(this.supportedDataSources, inlineResponse2005Bank.supportedDataSources);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, loginHint, bic, blz, blzs, loginFieldUserId, loginFieldCustomerId, loginFieldPin, isSupported, supportedDataSources);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2005Bank {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    loginHint: ").append(toIndentedString(loginHint)).append("\n");
    sb.append("    bic: ").append(toIndentedString(bic)).append("\n");
    sb.append("    blz: ").append(toIndentedString(blz)).append("\n");
    sb.append("    blzs: ").append(toIndentedString(blzs)).append("\n");
    sb.append("    loginFieldUserId: ").append(toIndentedString(loginFieldUserId)).append("\n");
    sb.append("    loginFieldCustomerId: ").append(toIndentedString(loginFieldCustomerId)).append("\n");
    sb.append("    loginFieldPin: ").append(toIndentedString(loginFieldPin)).append("\n");
    sb.append("    isSupported: ").append(toIndentedString(isSupported)).append("\n");
    sb.append("    supportedDataSources: ").append(toIndentedString(supportedDataSources)).append("\n");
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

