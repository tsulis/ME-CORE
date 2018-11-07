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
public class ProductVariant extends BaseEntity implements Serializable {

  private static final long serialVersionUID = -2280748379981070093L;
  private String variantId;
  private String name;
  private int sequence;
  private String properties;

  @Builder
  public ProductVariant(Date createdDate, String createdBy, Date updatedDate,
      String updatedBy, boolean isDeleted, boolean isActive, Date syncTime,
      String timestamp, String variantId, String name, int sequence, String properties) {
    super(createdDate, createdBy, updatedDate, updatedBy, isDeleted, isActive, syncTime, timestamp);
    this.variantId = variantId;
    this.name = name;
    this.sequence = sequence;
    this.properties = properties;
  }
}
