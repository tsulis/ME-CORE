package com.me.core.entity.product;

import com.me.core.entity.BaseMongo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product")
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseMongo implements Serializable {

  private static final long serialVersionUID = -1900604178649936332L;
  private String productId;
  private ProductHeader productHeader;
  private ProductType productType;
  private String fulfillmentServiceId;
  private String type;
  private boolean isDefault;
  private String handle;
  private String barcode;
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
  private boolean requireSerialNumber;

  private List<ProductInventory> inventories;
  private List<ProductImage> productImages;
  private List<ProductVariant> productVariants;
  private List<ModifierGroup> modifierGroups;
  private List<Modifier> modifiers;

  private String channel; //ME, ISELLER

  @Builder(builderMethodName = "productBuilder")
  public Product(String id, Long version, Date createdDate, String createdBy,
      Date updatedDate, String updatedBy, boolean isDeleted, boolean isActive,
      Date syncTime, String timestamp, String productId,
      ProductHeader productHeader, ProductType productType, String fulfillmentServiceId,
      String type, boolean isDefault, String handle, String barcode, String sku,
      String unitMeasurement, Double price, Double priceReference, boolean taxable,
      boolean soldable,
      boolean trackInventory, boolean allowNegativeStock, int alertAtStock, boolean requireShipping,
      int shippingWeight, String shippingUnit, int loyaltyPoints, String notes, int soldCount,
      String properties, Date externalSyncTime, boolean requireSerialNumber,
      List<ProductInventory> inventories,
      List<ProductImage> productImages,
      List<ProductVariant> productVariants,
      List<ModifierGroup> modifierGroups,
      List<Modifier> modifiers, String channel) {
    super(id, version, createdDate, createdBy, updatedDate, updatedBy, isDeleted, isActive,
        syncTime,
        timestamp);
    this.productId = productId;
    this.productHeader = productHeader;
    this.productType = productType;
    this.fulfillmentServiceId = fulfillmentServiceId;
    this.type = type;
    this.isDefault = isDefault;
    this.handle = handle;
    this.barcode = barcode;
    this.sku = sku;
    this.unitMeasurement = unitMeasurement;
    this.price = price;
    this.priceReference = priceReference;
    this.taxable = taxable;
    this.soldable = soldable;
    this.trackInventory = trackInventory;
    this.allowNegativeStock = allowNegativeStock;
    this.alertAtStock = alertAtStock;
    this.requireShipping = requireShipping;
    this.shippingWeight = shippingWeight;
    this.shippingUnit = shippingUnit;
    this.loyaltyPoints = loyaltyPoints;
    this.notes = notes;
    this.soldCount = soldCount;
    this.properties = properties;
    this.externalSyncTime = externalSyncTime;
    this.requireSerialNumber = requireSerialNumber;
    this.inventories = inventories;
    this.productImages = productImages;
    this.productVariants = productVariants;
    this.modifierGroups = modifierGroups;
    this.modifiers = modifiers;
    this.channel = channel;
  }
}

