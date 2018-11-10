package com.me.core.entity.order;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRefund {

  private String orderId;
  private String orderReference;
  private String channel;
  private String orderDate;
  private String refundDate;
  private Integer refundAmount;
  private List<Unit> unitsReturned;
}
