package com.me.core.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRequest implements Serializable {

  private static final long serialVersionUID = 3787762158499920043L;
  private String fullName;
  private String email;
  private String phone;
  private String password;

}
