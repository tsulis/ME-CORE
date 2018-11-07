package com.me.core.entity.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {

  private String productImageId;
  private String url;
  private boolean isDefault;
  private String altText;

}
