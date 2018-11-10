package com.me.core.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderTransaction {

  private String orderReference;
  private String transactionDate;
  private String transactionId;
  private String channel;
  private String type;
  private String status;
  private String gateway;
  private String paymentTypeId;
  private String paymentTypeName;
  private String currency;
  private Double amount;

}
