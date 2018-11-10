package com.me.core.entity.product;

import com.me.core.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductHeader extends BaseEntity implements Serializable {

  private static final long serialVersionUID = 5842637091581197571L;
  private String productHeaderId;
  private String name;
  private String description;
  private String outletId;
  private String vendorId;
  private String type;
  private boolean visibleOnline;
  private boolean visiblePos;
  private String properties;

  private List<ProductHeaderImage> productHeaderImages;
  private List<Tag> tags;

  @Builder(builderMethodName = "productHeaderBuilder")
  public ProductHeader(Date createdDate, String createdBy, Date updatedDate,
      String updatedBy, boolean isDeleted, boolean isActive, Date syncTime,
      String timestamp, String productHeaderId, String name, String description,
      String outletId, String vendorId, String type, boolean visibleOnline, boolean visiblePos,
      String properties,
      List<ProductHeaderImage> productHeaderImages,
      List<Tag> tags) {
    super(createdDate, createdBy, updatedDate, updatedBy, isDeleted, isActive, syncTime, timestamp);
    this.productHeaderId = productHeaderId;
    this.name = name;
    this.description = description;
    this.outletId = outletId;
    this.vendorId = vendorId;
    this.type = type;
    this.visibleOnline = visibleOnline;
    this.visiblePos = visiblePos;
    this.properties = properties;
    this.productHeaderImages = productHeaderImages;
    this.tags = tags;
  }
}
