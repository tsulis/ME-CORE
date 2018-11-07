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
public class ProductInventory extends BaseEntity implements Serializable {

  private static final long serialVersionUID = 6045265757419204920L;
  private String outletId;
  private String outletName;
  private String unitInStock;

  @Builder
  public ProductInventory(Date createdDate, String createdBy, Date updatedDate,
      String updatedBy, boolean isDeleted, boolean isActive, Date syncTime,
      String timestamp, String outletId, String outletName, String unitInStock) {
    super(createdDate, createdBy, updatedDate, updatedBy, isDeleted, isActive, syncTime, timestamp);
    this.outletId = outletId;
    this.outletName = outletName;
    this.unitInStock = unitInStock;
  }
}
