package com.me.core.model.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

  private static final long serialVersionUID = -2994640930132135219L;
  private String email;
  private String fullName;
  private boolean enabled;

}
