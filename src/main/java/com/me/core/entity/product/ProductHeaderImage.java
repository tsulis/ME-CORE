package com.me.core.entity.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductHeaderImage {

  private String productHeaderImageId;
  private String url;
  private boolean isDefault;
  private String altText;
}
