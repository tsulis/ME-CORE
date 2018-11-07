package com.me.core.entity.store;

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
@Document(collection = "store")
@EqualsAndHashCode(callSuper = true)
public class Store extends BaseMongo implements Serializable {

  private static final long serialVersionUID = 1494777135647308691L;
  private String storeId;
  private String ownerId;
  private String businessType;
  private String businessCategory;
  private String name;
  private String legalName;
  private String description;
  private String phone;
  private String address;
  private String address2;
  private String countryCode;
  private String country;
  private String state;
  private String city;
  private String zip;
  private String website;
  private String facebook;
  private String twitter;
  private String email;
  private Date joinDate;
  private Date joinPlanDate;
  private Date pauseDate;
  private Date closeDate;
  private String storeStatus;
  private String storePlan;
  private String connectionString;
  private String apiKey;
  private String metaFields;

  private StoreSetting storeSetting;
  private List<Outlet> outlets;

  private String channel; //ME, ISELLER

  @Builder
  public Store(String id, Long version, Date createdDate, String createdBy,
      Date updatedDate, String updatedBy, boolean isDeleted, boolean isActive,
      Date syncTime, String timestamp, String storeId, String ownerId, String businessType,
      String businessCategory, String name, String legalName, String description,
      String phone, String address, String address2, String countryCode, String country,
      String state, String city, String zip, String website, String facebook,
      String twitter, String email, Date joinDate, Date joinPlanDate, Date pauseDate,
      Date closeDate, String storeStatus, String storePlan, String connectionString,
      String apiKey, String metaFields, StoreSetting storeSetting,
      List<Outlet> outlets, String channel) {
    super(id, version, createdDate, createdBy, updatedDate, updatedBy, isDeleted, isActive,
        syncTime,
        timestamp);
    this.storeId = storeId;
    this.ownerId = ownerId;
    this.businessType = businessType;
    this.businessCategory = businessCategory;
    this.name = name;
    this.legalName = legalName;
    this.description = description;
    this.phone = phone;
    this.address = address;
    this.address2 = address2;
    this.countryCode = countryCode;
    this.country = country;
    this.state = state;
    this.city = city;
    this.zip = zip;
    this.website = website;
    this.facebook = facebook;
    this.twitter = twitter;
    this.email = email;
    this.joinDate = joinDate;
    this.joinPlanDate = joinPlanDate;
    this.pauseDate = pauseDate;
    this.closeDate = closeDate;
    this.storeStatus = storeStatus;
    this.storePlan = storePlan;
    this.connectionString = connectionString;
    this.apiKey = apiKey;
    this.metaFields = metaFields;
    this.storeSetting = storeSetting;
    this.outlets = outlets;
    this.channel = channel;
  }
}
