package com.testmarket.codegen.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.testmarket.codegen.model.ShopUnitType;
import java.util.Arrays;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ShopUnitImport
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-06-26T13:46:50.872481+04:00[Asia/Tbilisi]")
public class ShopUnitImport {

  @JsonProperty("id")
  private UUID id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("parentId")
  private JsonNullable<UUID> parentId = JsonNullable.undefined();

  @JsonProperty("type")
  private ShopUnitType type;

  @JsonProperty("price")
  private JsonNullable<Long> price = JsonNullable.undefined();

  public ShopUnitImport id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Уникальный идентфикатор
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", example = "3fa85f64-5717-4562-b3fc-2c963f66a333", description = "Уникальный идентфикатор", required = true)
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public ShopUnitImport name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Имя элемента.
   * @return name
  */
  @NotNull 
  @Schema(name = "name", description = "Имя элемента.", required = true)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ShopUnitImport parentId(UUID parentId) {
    this.parentId = JsonNullable.of(parentId);
    return this;
  }

  /**
   * UUID родительской категории
   * @return parentId
  */
  @Valid 
  @Schema(name = "parentId", example = "3fa85f64-5717-4562-b3fc-2c963f66a333", description = "UUID родительской категории", required = false)
  public JsonNullable<UUID> getParentId() {
    return parentId;
  }

  public void setParentId(JsonNullable<UUID> parentId) {
    this.parentId = parentId;
  }

  public ShopUnitImport type(ShopUnitType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @NotNull @Valid 
  @Schema(name = "type", required = true)
  public ShopUnitType getType() {
    return type;
  }

  public void setType(ShopUnitType type) {
    this.type = type;
  }

  public ShopUnitImport price(Long price) {
    this.price = JsonNullable.of(price);
    return this;
  }

  /**
   * Целое число, для категорий поле должно содержать null.
   * @return price
  */
  
  @Schema(name = "price", description = "Целое число, для категорий поле должно содержать null.", required = false)
  public JsonNullable<Long> getPrice() {
    return price;
  }

  public void setPrice(JsonNullable<Long> price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShopUnitImport shopUnitImport = (ShopUnitImport) o;
    return Objects.equals(this.id, shopUnitImport.id) &&
        Objects.equals(this.name, shopUnitImport.name) &&
        Objects.equals(this.parentId, shopUnitImport.parentId) &&
        Objects.equals(this.type, shopUnitImport.type) &&
        Objects.equals(this.price, shopUnitImport.price);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, parentId, type, price);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShopUnitImport {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

