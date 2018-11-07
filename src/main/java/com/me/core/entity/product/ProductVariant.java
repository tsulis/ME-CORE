package com.me.core.entity.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariant {

  private String variantId;
  private String name;
  private int sequence;
  private String properties;
}
