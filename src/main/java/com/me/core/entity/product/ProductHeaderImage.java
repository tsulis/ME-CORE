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
public class ProductHeaderImage extends BaseEntity implements Serializable {

  private static final long serialVersionUID = 7466684946896577962L;
  private String productHeaderImageId;
  private String url;
  private boolean isDefault;
  private String altText;

  @Builder(builderMethodName = "productHeaderImageBuilder")
  public ProductHeaderImage(Date createdDate, String createdBy, Date updatedDate,
      String updatedBy, boolean isDeleted, boolean isActive, Date syncTime,
      String timestamp, String productHeaderImageId, String url, boolean isDefault,
      String altText) {
    super(createdDate, createdBy, updatedDate, updatedBy, isDeleted, isActive, syncTime, timestamp);
    this.productHeaderImageId = productHeaderImageId;
    this.url = url;
    this.isDefault = isDefault;
    this.altText = altText;
  }
}
