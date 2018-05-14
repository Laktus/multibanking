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
import io.swagger.client.model.Category;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Cash flow
 */
@ApiModel(description = "Cash flow")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-14T19:12:52.919Z")
public class CashFlow {
  @SerializedName("category")
  private Category category = null;

  @SerializedName("income")
  private BigDecimal income = null;

  @SerializedName("spending")
  private BigDecimal spending = null;

  @SerializedName("balance")
  private BigDecimal balance = null;

  public CashFlow category(Category category) {
    this.category = category;
    return this;
  }

   /**
   * Category of this cash flow. When null, then this is the cash flow of transactions that do not have a category.
   * @return category
  **/
  @ApiModelProperty(value = "Category of this cash flow. When null, then this is the cash flow of transactions that do not have a category.")
  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public CashFlow income(BigDecimal income) {
    this.income = income;
    return this;
  }

   /**
   * The total calculated income for the given category
   * @return income
  **/
  @ApiModelProperty(required = true, value = "The total calculated income for the given category")
  public BigDecimal getIncome() {
    return income;
  }

  public void setIncome(BigDecimal income) {
    this.income = income;
  }

  public CashFlow spending(BigDecimal spending) {
    this.spending = spending;
    return this;
  }

   /**
   * The total calculated spending for the given category
   * @return spending
  **/
  @ApiModelProperty(required = true, value = "The total calculated spending for the given category")
  public BigDecimal getSpending() {
    return spending;
  }

  public void setSpending(BigDecimal spending) {
    this.spending = spending;
  }

  public CashFlow balance(BigDecimal balance) {
    this.balance = balance;
    return this;
  }

   /**
   * The calculated balance for the given category
   * @return balance
  **/
  @ApiModelProperty(required = true, value = "The calculated balance for the given category")
  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CashFlow cashFlow = (CashFlow) o;
    return Objects.equals(this.category, cashFlow.category) &&
        Objects.equals(this.income, cashFlow.income) &&
        Objects.equals(this.spending, cashFlow.spending) &&
        Objects.equals(this.balance, cashFlow.balance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, income, spending, balance);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CashFlow {\n");
    
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    income: ").append(toIndentedString(income)).append("\n");
    sb.append("    spending: ").append(toIndentedString(spending)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
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

