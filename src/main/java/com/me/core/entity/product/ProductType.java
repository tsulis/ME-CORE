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
public class ProductType extends BaseEntity implements Serializable {

  private static final long serialVersionUID = -5802266932141927059L;
  private String productTypeId;
  private String name;
  private String color;

  @Builder
  public ProductType(Date createdDate, String createdBy, Date updatedDate,
      String updatedBy, boolean isDeleted, boolean isActive, Date syncTime,
      String timestamp, String productTypeId, String name, String color) {
    super(createdDate, createdBy, updatedDate, updatedBy, isDeleted, isActive, syncTime, timestamp);
    this.productTypeId = productTypeId;
    this.name = name;
    this.color = color;
  }
}
