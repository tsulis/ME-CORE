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
public class Tag extends BaseEntity implements Serializable {

  private static final long serialVersionUID = -8244399400623343473L;
  private String name;
  private String tagId;
  private String entityType;

  @Builder(builderMethodName = "tagBuilder")
  public Tag(Date createdDate, String createdBy, Date updatedDate,
      String updatedBy, boolean isDeleted, boolean isActive, Date syncTime,
      String timestamp, String name, String tagId, String entityType) {
    super(createdDate, createdBy, updatedDate, updatedBy, isDeleted, isActive, syncTime, timestamp);
    this.name = name;
    this.tagId = tagId;
    this.entityType = entityType;
  }
}
