package com.me.core.entity;

import com.me.core.constant.CollectionName;
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
@Document(collection = CollectionName.USER)
public class User extends BaseMongo implements Serializable {

  private static final long serialVersionUID = 4305712431332037633L;
  private String fullName;
  private String email;
  private String phone;
  private String dob;
  private String photo; //BASE64
  private String photoUrl;
  private String password;
  private String salt;
  private Double wallet;
  private int point;
  private int verificationCode; //ex: 12345
  private boolean enabled; // status user
  private boolean isLogin;
  private Date lastPasswordResetDate;

  @Builder
  public User(String id, Long version, Date createdDate, String createdBy, Date updatedDate,
      String updatedBy, boolean isDeleted, boolean isActive, Date syncTime,
      String timestamp, String fullName, String email, String phone, String dob,
      String photo, String photoUrl, String password, String salt, Double wallet, int point,
      int verificationCode, boolean enabled, boolean isLogin, Date lastPasswordResetDate) {
    super(id, version, createdDate, createdBy, updatedDate, updatedBy, isDeleted, isActive,
        syncTime,
        timestamp);
    this.fullName = fullName;
    this.email = email;
    this.phone = phone;
    this.dob = dob;
    this.photo = photo;
    this.photoUrl = photoUrl;
    this.password = password;
    this.salt = salt;
    this.wallet = wallet;
    this.point = point;
    this.verificationCode = verificationCode;
    this.enabled = enabled;
    this.isLogin = isLogin;
    this.lastPasswordResetDate = lastPasswordResetDate;
  }
}


