package com.me.core.entity.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductType {

  private String productTypeId;
  private String name;
  private String color;

}
