package com.me.core.entity.store;

import com.me.core.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class StoreSetting extends BaseEntity implements Serializable {

  private static final long serialVersionUID = -8715485659981927139L;
  private String photoUrl;
  private String logoUrl;
  private String culture;
  private String timezone;
  private String currency;
  private String currencyFormat;
  private String customerEmail;
  private boolean automaticSkuGeneration;
  private String skuGenerationMode;
  private int currentSkuSequenceNumber;
  private String orderFormatRegisterPrefix;
  private int orderFormatBaseNumber;
  private String orderFormatRegisterSuffix;
  private String requireAdminElevation;
  private boolean changeUserRequirePin;
  private String customSettings;
  private String notificationSettings;
  private String onlineStoreSettings;
  private String taxSettings;
  private String gatewaySettings;
  private String paymentSettings;
  private String businessSettings;
  private String integrationSettings;
  private boolean loyaltyEnabled;
  private Double loyaltySpentAmount;
  private int loyaltyPointUnit;
  private int loyaltyExchangePoint;
  private Double loyaltyExchangeAmount;
  private String shippingOriginId;

  @Builder
  public StoreSetting(Date createdDate, String createdBy, Date updatedDate,
      String updatedBy, boolean isDeleted, boolean isActive, Date syncTime,
      String timestamp, String photoUrl, String logoUrl, String culture, String timezone,
      String currency, String currencyFormat, String customerEmail, boolean automaticSkuGeneration,
      String skuGenerationMode, int currentSkuSequenceNumber,
      String orderFormatRegisterPrefix, int orderFormatBaseNumber,
      String orderFormatRegisterSuffix, String requireAdminElevation, boolean changeUserRequirePin,
      String customSettings, String notificationSettings, String onlineStoreSettings,
      String taxSettings, String gatewaySettings, String paymentSettings,
      String businessSettings, String integrationSettings, boolean loyaltyEnabled,
      Double loyaltySpentAmount, int loyaltyPointUnit, int loyaltyExchangePoint,
      Double loyaltyExchangeAmount, String shippingOriginId) {
    super(createdDate, createdBy, updatedDate, updatedBy, isDeleted, isActive, syncTime, timestamp);
    this.photoUrl = photoUrl;
    this.logoUrl = logoUrl;
    this.culture = culture;
    this.timezone = timezone;
    this.currency = currency;
    this.currencyFormat = currencyFormat;
    this.customerEmail = customerEmail;
    this.automaticSkuGeneration = automaticSkuGeneration;
    this.skuGenerationMode = skuGenerationMode;
    this.currentSkuSequenceNumber = currentSkuSequenceNumber;
    this.orderFormatRegisterPrefix = orderFormatRegisterPrefix;
    this.orderFormatBaseNumber = orderFormatBaseNumber;
    this.orderFormatRegisterSuffix = orderFormatRegisterSuffix;
    this.requireAdminElevation = requireAdminElevation;
    this.changeUserRequirePin = changeUserRequirePin;
    this.customSettings = customSettings;
    this.notificationSettings = notificationSettings;
    this.onlineStoreSettings = onlineStoreSettings;
    this.taxSettings = taxSettings;
    this.gatewaySettings = gatewaySettings;
    this.paymentSettings = paymentSettings;
    this.businessSettings = businessSettings;
    this.integrationSettings = integrationSettings;
    this.loyaltyEnabled = loyaltyEnabled;
    this.loyaltySpentAmount = loyaltySpentAmount;
    this.loyaltyPointUnit = loyaltyPointUnit;
    this.loyaltyExchangePoint = loyaltyExchangePoint;
    this.loyaltyExchangeAmount = loyaltyExchangeAmount;
    this.shippingOriginId = shippingOriginId;
  }
}
