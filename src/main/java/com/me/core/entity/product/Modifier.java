package com.me.core.entity.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Modifier {

  private String modifierId;
  private ModifierGroup modifierGroup;
  private String name;
  private String imageUrl;
  private Double price;
  private int position;
  private String color;
  private int quantity;
  private String properties;

}
