package com.me.core.entity.product;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductHeader {

  private String productHeaderId;
  private String name;
  private String description;
  private String outletId;
  private String vendorId;
  private String type;
  private boolean visibleOnline;
  private boolean visiblePos;
  private String properties;

  private List<ProductHeaderImage> productHeaderImages;
  private List<Tag> tags;
}
