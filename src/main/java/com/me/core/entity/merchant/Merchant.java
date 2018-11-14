package com.me.core.entity.merchant;

import com.me.core.entity.BaseMongo;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Document(collection = "merchant")
public class Merchant extends BaseMongo implements Serializable {

  private String merchantId;
  private String email;
  private String name;
  private Date dob;
  private String photo; //BASE64
  private String photoUrl;
  private String phone;
  private String address;
  private String type; //MerchantA, MerchantB, MerchantC

  private String salt;
  private String password;
  private boolean enabled = true; // status merchant
  private boolean isLogin;
  private Date lastPasswordResetDate;

  @Builder
  public Merchant(String id, Long version, Date createdDate, String createdBy,
      Date updatedDate, String updatedBy, boolean isDeleted, boolean isActive,
      Date syncTime, String timestamp, String merchantId, String email, String name,
      Date dob, String photo, String photoUrl, String phone, String address, String type,
      String salt, String password, boolean enabled, boolean isLogin,
      Date lastPasswordResetDate) {
    super(id, version, createdDate, createdBy, updatedDate, updatedBy, isDeleted, isActive,
        syncTime,
        timestamp);
    this.merchantId = merchantId;
    this.email = email;
    this.name = name;
    this.dob = dob;
    this.photo = photo;
    this.photoUrl = photoUrl;
    this.phone = phone;
    this.address = address;
    this.type = type;
    this.salt = salt;
    this.password = password;
    this.enabled = enabled;
    this.isLogin = isLogin;
    this.lastPasswordResetDate = lastPasswordResetDate;
  }
}
