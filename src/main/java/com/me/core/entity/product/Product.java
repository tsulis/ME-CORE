package com.me.core.entity.product;

import com.me.core.entity.BaseMongo;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product")
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseMongo {

  private String productId;
  private ProductHeader productHeader;
  private ProductType productType;
  private String fulfillmentServiceId;
  private String type;
  private boolean isDefault;
  private String handle;
  private String barCode;
  private String sku;
  private String unitMeasurement;
  private Double price;
  private Double priceReference;
  private boolean taxable;
  private boolean soldable;
  private boolean trackInventory;
  private boolean allowNegativeStock;
  private int alertAtStock;
  private boolean requireShipping;
  private int shippingWeight;
  private String shippingUnit;
  private int loyaltyPoints;
  private String notes;
  private int soldCount;
  private String properties;
  private Date externalSyncTime;
  private boolean isActive;
  private String timestamp;
  private boolean requireSerialNumber;

  private List<ProductImage> productImages;
  private List<ProductVariant> productVariants;
  private List<ModifierGroup> modifierGroups;
  private List<Modifier> modifiers;
}

