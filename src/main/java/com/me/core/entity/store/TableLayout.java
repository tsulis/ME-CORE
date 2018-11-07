package com.me.core.entity.store;

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
public class TableLayout extends BaseEntity implements Serializable {

  private static final long serialVersionUID = 9167255336345238723L;

  private String tableLayoutId;

  @Builder
  public TableLayout(Date createdDate, String createdBy, Date updatedDate, String updatedBy,
      boolean isDeleted, boolean isActive, Date syncTime, String timestamp,
      String tableLayoutId) {
    super(createdDate, createdBy, updatedDate, updatedBy, isDeleted, isActive, syncTime, timestamp);
    this.tableLayoutId = tableLayoutId;
  }
}
