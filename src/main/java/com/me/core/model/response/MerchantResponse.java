package com.me.core.model.response;

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
public class MerchantResponse implements Serializable {

  private String id;
  private String email;
  private String name;
  private Date dob;
  private String photo; //BASE64
  private String photoUrl;
  private String phone;
  private String address;
  private String type; //MerchantA, MerchantB, MerchantC

}
