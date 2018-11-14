package com.me.core.model.request;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MerchantRequest implements Serializable {

  private String email;
  private String name;
  private Date dob;
  private String photo; //BASE64
  private String photoUrl;
  private String phone;
  private String address;
  private String type; //MerchantA, MerchantB, MerchantC
  private String password;
}
