package com.me.core.entity.product;

import com.me.core.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Modifier extends BaseEntity implements Serializable {

  private static final long serialVersionUID = -6870474364689473868L;
  private String modifierId;
  private ModifierGroup modifierGroup;
  private String name;
  private String imageUrl;
  private Double price;
  private int position;
  private String color;
  private int quantity;
  private String properties;

  @Builder
  public Modifier(Date createdDate, String createdBy, Date updatedDate,
      String updatedBy, boolean isDeleted, boolean isActive, Date syncTime,
      String timestamp, String modifierId, ModifierGroup modifierGroup, String name,
      String imageUrl, Double price, int position, String color, int quantity,
      String properties) {
    super(createdDate, createdBy, updatedDate, updatedBy, isDeleted, isActive, syncTime, timestamp);
    this.modifierId = modifierId;
    this.modifierGroup = modifierGroup;
    this.name = name;
    this.imageUrl = imageUrl;
    this.price = price;
    this.position = position;
    this.color = color;
    this.quantity = quantity;
    this.properties = properties;
  }
}
