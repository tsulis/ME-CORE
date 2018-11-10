package com.me.core.entity.order;

import java.util.List;

public class Fulfillment {

  private String orderId;
  private String orderReference;
  private String channel;
  private String orderDate;
  private String fulfillDate;
  private List<Unit> unitsFulfilled;
}
