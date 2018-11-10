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
public class ModifierGroup extends BaseEntity implements Serializable {

  private static final long serialVersionUID = -4365573487546207345L;
  private String outletId;
  private String name;
  private String color;
  private boolean multiSelection;
  private int minSelection;
  private int maxSelection;
  private String properties;
  private List<Modifier> modifiers;

  @Builder(builderMethodName = "modifierGroupBuilder")
  public ModifierGroup(Date createdDate, String createdBy, Date updatedDate,
      String updatedBy, boolean isDeleted, boolean isActive, Date syncTime,
      String timestamp, String outletId, String name, String color, boolean multiSelection,
      int minSelection, int maxSelection, String properties,
      List<Modifier> modifiers) {
    super(createdDate, createdBy, updatedDate, updatedBy, isDeleted, isActive, syncTime, timestamp);
    this.outletId = outletId;
    this.name = name;
    this.color = color;
    this.multiSelection = multiSelection;
    this.minSelection = minSelection;
    this.maxSelection = maxSelection;
    this.properties = properties;
    this.modifiers = modifiers;
  }
}
