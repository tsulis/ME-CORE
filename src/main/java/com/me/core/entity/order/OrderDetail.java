package com.me.core.entity.order;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

  private String orderDetailId;
  private String productId;
  private String productName;
  private String productGenericName;
  private String productVariantId;
  private String productVariantName;
  private String productModifierId;
  private String productModifierName;
  private String notes;
  private String vendor;
  private String sku;
  private String fulfillmentStatus;
  private Integer quantity;
  private Double basePrice;
  private Double priceBeforeTax;
  private Double priceAfterTax;
  private Double discountAmount;
  private Double discountPercentage;
  private boolean taxable;
  private Double taxPercentage;
  private Double taxAmount;
  private boolean requireShipping;
  private String weight;
  private String type;
  private boolean trackInventory;
  private String modifierProductType;
  private String modifierProductId;
  private Integer modifierProductQuantity;
  private String[] modifierProductComposites;
  private String productComposites;
  private String productCombos;
  private List<OrderPromotion> promotions;
  private List<OrderDiscount> discounts;
  private List<OrderTransaction> transactions;
}
