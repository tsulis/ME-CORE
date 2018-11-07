package com.me.core.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "baseEntityBuilder")
public class BaseEntity {

  private Date createdDate;
  private String createdBy;
  private Date updatedDate;
  private String updatedBy;
  private boolean isDeleted;
  private boolean isActive;
  private Date syncTime;
  private String timestamp;

}
