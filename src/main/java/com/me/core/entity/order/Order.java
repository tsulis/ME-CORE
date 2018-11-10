package com.me.core.entity.order;

import com.me.core.entity.BaseMongo;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseMongo implements Serializable {

  private String orderId;
  private String orderReference;
  private String channel; //pos
  private String orderDate;
  private String closedDate;
  private String status; //completed
  private String paymentStatus; //paid
  private String fulfillmentStatus;
  private String notes;
  private String processingMethod;
  private String cancelDate;
  private String cancelReason;
  private String outletId;
  private String outletName;
  private String registerId;
  private String registerName;
  private String customerId;
  private String customerFirstName;
  private String customerLastName;
  private String customerEmail;
  private String serverId;
  private String serverFirstName;
  private String serverLastName;
  private String cashierId;
  private String cashierFirstName;
  private String cashierLastName;
  private String currency;
  private Double totalOrderAmount;
  private Integer discountPercentage;
  private Double totalDiscountAmount;
  private Double totalPromotionAmount;
  private Double subtotal;
  private Double totalTaxAmount;
  private Double totalAdditionalFinalAmount;
  private Double totalAdditionalSubtotalAmount;
  private Double totalAdditionalOrderAmount;
  private Double roundingAmount;
  private Double totalAmount;
  private Double buyingPrice;
  private Double totalShippingAmount;
  private Double totalWeight;
  private boolean taxInclusive;
  private boolean onAccount;
  private int remainingOnAccount;
  private String billing;
  private String shipping;
  private List<OrderDetail> orderDetails;

}
