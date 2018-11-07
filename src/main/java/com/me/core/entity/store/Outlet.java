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
public class Outlet extends BaseEntity implements Serializable {

  private static final long serialVersionUID = -7551571948210674014L;

  private String outletId;
  private String name;
  private String phone;
  private String address;
  private String address2;
  private String countryCode;
  private String country;
  private String state;
  private String city;
  private String zip;
  private String contactName;
  private String email;
  private String website;
  private String facebook;
  private String twitter;
  private String receiptTemplateId;
  private boolean isPrimary;
  private String taxId;
  private String properties;
  private OutletSetting outletSetting;

  @Builder
  public Outlet(Date createdDate, String createdBy, Date updatedDate,
      String updatedBy, boolean isDeleted, boolean isActive, Date syncTime,
      String timestamp, String outletId, String name, String phone, String address,
      String address2, String countryCode, String country, String state, String city,
      String zip, String contactName, String email, String website, String facebook,
      String twitter, String receiptTemplateId, boolean isPrimary, String taxId,
      String properties, OutletSetting outletSetting) {
    super(createdDate, createdBy, updatedDate, updatedBy, isDeleted, isActive, syncTime, timestamp);
    this.outletId = outletId;
    this.name = name;
    this.phone = phone;
    this.address = address;
    this.address2 = address2;
    this.countryCode = countryCode;
    this.country = country;
    this.state = state;
    this.city = city;
    this.zip = zip;
    this.contactName = contactName;
    this.email = email;
    this.website = website;
    this.facebook = facebook;
    this.twitter = twitter;
    this.receiptTemplateId = receiptTemplateId;
    this.isPrimary = isPrimary;
    this.taxId = taxId;
    this.properties = properties;
    this.outletSetting = outletSetting;
  }
}
