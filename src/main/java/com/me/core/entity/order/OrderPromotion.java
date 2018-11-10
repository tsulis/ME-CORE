package com.me.core.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderPromotion {

  private String promotionId;
  private String promotionName;
  private String promotionType;
  private Double promotionAmount;

}
