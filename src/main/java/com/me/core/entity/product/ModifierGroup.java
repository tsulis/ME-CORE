package com.me.core.entity.product;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModifierGroup {

  private String outletId;
  private String name;
  private String color;
  private boolean multiSelection;
  private int minSelection;
  private int maxSelection;
  private String properties;
  private List<Modifier> modifiers;
}
