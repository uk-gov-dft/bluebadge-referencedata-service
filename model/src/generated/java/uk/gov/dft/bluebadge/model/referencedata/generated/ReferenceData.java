package uk.gov.dft.bluebadge.model.referencedata.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.constraints.*;
import org.springframework.validation.annotation.Validated;

/** ReferenceData */
@Validated
public class ReferenceData {
  @JsonProperty("categoryId")
  private String categoryId = null;

  @JsonProperty("shortCode")
  private String shortCode = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("subgroupShortCode")
  private String subgroupShortCode = null;

  @JsonProperty("subgroupDescription")
  private String subgroupDescription = null;

  @JsonProperty("displayOrder")
  private Integer displayOrder = null;

  public ReferenceData categoryId(String categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  /**
   * Group of data.
   *
   * @return categoryId
   */
  @ApiModelProperty(value = "Group of data.")
  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  public ReferenceData shortCode(String shortCode) {
    this.shortCode = shortCode;
    return this;
  }

  /**
   * Identifier of data item within category
   *
   * @return shortCode
   */
  @ApiModelProperty(value = "Identifier of data item within category")
  public String getShortCode() {
    return shortCode;
  }

  public void setShortCode(String shortCode) {
    this.shortCode = shortCode;
  }

  public ReferenceData description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Display value of data item
   *
   * @return description
   */
  @ApiModelProperty(value = "Display value of data item")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ReferenceData subgroupShortCode(String subgroupShortCode) {
    this.subgroupShortCode = subgroupShortCode;
    return this;
  }

  /**
   * Id of a subgroup
   *
   * @return subgroupShortCode
   */
  @ApiModelProperty(value = "Id of a subgroup")
  public String getSubgroupShortCode() {
    return subgroupShortCode;
  }

  public void setSubgroupShortCode(String subgroupShortCode) {
    this.subgroupShortCode = subgroupShortCode;
  }

  public ReferenceData subgroupDescription(String subgroupDescription) {
    this.subgroupDescription = subgroupDescription;
    return this;
  }

  /**
   * Display value of a sub group
   *
   * @return subgroupDescription
   */
  @ApiModelProperty(value = "Display value of a sub group")
  public String getSubgroupDescription() {
    return subgroupDescription;
  }

  public void setSubgroupDescription(String subgroupDescription) {
    this.subgroupDescription = subgroupDescription;
  }

  public ReferenceData displayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
    return this;
  }

  /**
   * Order to display in a list within category
   *
   * @return displayOrder
   */
  @ApiModelProperty(value = "Order to display in a list within category")
  public Integer getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReferenceData referenceData = (ReferenceData) o;
    return Objects.equals(this.categoryId, referenceData.categoryId)
        && Objects.equals(this.shortCode, referenceData.shortCode)
        && Objects.equals(this.description, referenceData.description)
        && Objects.equals(this.subgroupShortCode, referenceData.subgroupShortCode)
        && Objects.equals(this.subgroupDescription, referenceData.subgroupDescription)
        && Objects.equals(this.displayOrder, referenceData.displayOrder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        categoryId, shortCode, description, subgroupShortCode, subgroupDescription, displayOrder);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReferenceData {\n");

    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    shortCode: ").append(toIndentedString(shortCode)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    subgroupShortCode: ").append(toIndentedString(subgroupShortCode)).append("\n");
    sb.append("    subgroupDescription: ")
        .append(toIndentedString(subgroupDescription))
        .append("\n");
    sb.append("    displayOrder: ").append(toIndentedString(displayOrder)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
