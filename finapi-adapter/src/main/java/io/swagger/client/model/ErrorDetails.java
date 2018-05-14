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

/**
 * Error details
 */
@ApiModel(description = "Error details")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-14T19:12:52.919Z")
public class ErrorDetails {
  @SerializedName("message")
  private String message = null;

  /**
   * Error code. See the documentation of the individual services for details about what values may be returned.
   */
  @JsonAdapter(CodeEnum.Adapter.class)
  public enum CodeEnum {
    MISSING_FIELD("MISSING_FIELD"),
    
    UNKNOWN_ENTITY("UNKNOWN_ENTITY"),
    
    METHOD_NOT_ALLOWED("METHOD_NOT_ALLOWED"),
    
    ENTITY_EXISTS("ENTITY_EXISTS"),
    
    ILLEGAL_ENTITY_STATE("ILLEGAL_ENTITY_STATE"),
    
    UNEXPECTED_ERROR("UNEXPECTED_ERROR"),
    
    ILLEGAL_FIELD_VALUE("ILLEGAL_FIELD_VALUE"),
    
    UNAUTHORIZED_ACCESS("UNAUTHORIZED_ACCESS"),
    
    BAD_REQUEST("BAD_REQUEST"),
    
    UNSUPPORTED_ORDER("UNSUPPORTED_ORDER"),
    
    ILLEGAL_PAGE_SIZE("ILLEGAL_PAGE_SIZE"),
    
    INVALID_FILTER_OPTIONS("INVALID_FILTER_OPTIONS"),
    
    TOO_MANY_IDS("TOO_MANY_IDS"),
    
    BANK_SERVER_REJECTION("BANK_SERVER_REJECTION"),
    
    IBAN_ONLY_MONEY_TRANSFER_NOT_SUPPORTED("IBAN_ONLY_MONEY_TRANSFER_NOT_SUPPORTED"),
    
    IBAN_ONLY_DIRECT_DEBIT_NOT_SUPPORTED("IBAN_ONLY_DIRECT_DEBIT_NOT_SUPPORTED"),
    
    COLLECTIVE_MONEY_TRANSFER_NOT_SUPPORTED("COLLECTIVE_MONEY_TRANSFER_NOT_SUPPORTED"),
    
    INVALID_TWO_STEP_PROCEDURE("INVALID_TWO_STEP_PROCEDURE"),
    
    MISSING_TWO_STEP_PROCEDURE("MISSING_TWO_STEP_PROCEDURE"),
    
    UNSUPPORTED_MEDIA_TYPE("UNSUPPORTED_MEDIA_TYPE"),
    
    UNSUPPORTED_BANK("UNSUPPORTED_BANK"),
    
    USER_NOT_VERIFIED("USER_NOT_VERIFIED"),
    
    USER_ALREADY_VERIFIED("USER_ALREADY_VERIFIED"),
    
    INVALID_TOKEN("INVALID_TOKEN"),
    
    LOCKED("LOCKED"),
    
    NO_ACCOUNTS_FOR_TYPE_LIST("NO_ACCOUNTS_FOR_TYPE_LIST"),
    
    FORBIDDEN("FORBIDDEN"),
    
    NO_EXISTING_CHALLENGE("NO_EXISTING_CHALLENGE"),
    
    ADDITIONAL_AUTHENTICATION_REQUIRED("ADDITIONAL_AUTHENTICATION_REQUIRED");

    private String value;

    CodeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CodeEnum fromValue(String text) {
      for (CodeEnum b : CodeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<CodeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CodeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CodeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return CodeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("code")
  private CodeEnum code = null;

  /**
   * Error type. BUSINESS errors depict German error messages for the user, e.g. from a bank server. TECHNICAL errors depict internal errors.
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    BUSINESS("BUSINESS"),
    
    TECHNICAL("TECHNICAL");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("type")
  private TypeEnum type = null;

  public ErrorDetails message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Error message
   * @return message
  **/
  @ApiModelProperty(value = "Error message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorDetails code(CodeEnum code) {
    this.code = code;
    return this;
  }

   /**
   * Error code. See the documentation of the individual services for details about what values may be returned.
   * @return code
  **/
  @ApiModelProperty(value = "Error code. See the documentation of the individual services for details about what values may be returned.")
  public CodeEnum getCode() {
    return code;
  }

  public void setCode(CodeEnum code) {
    this.code = code;
  }

  public ErrorDetails type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Error type. BUSINESS errors depict German error messages for the user, e.g. from a bank server. TECHNICAL errors depict internal errors.
   * @return type
  **/
  @ApiModelProperty(value = "Error type. BUSINESS errors depict German error messages for the user, e.g. from a bank server. TECHNICAL errors depict internal errors.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorDetails errorDetails = (ErrorDetails) o;
    return Objects.equals(this.message, errorDetails.message) &&
        Objects.equals(this.code, errorDetails.code) &&
        Objects.equals(this.type, errorDetails.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, code, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorDetails {\n");
    
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

