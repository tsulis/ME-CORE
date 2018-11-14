package com.me.core.libraries.exception;

import com.me.core.constant.enums.ResponseCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BusinessLogicException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private String code;
  private String message;

  public BusinessLogicException(String code, String message) {
    super();
    this.setCode(code);
    this.setMessage(message);
  }

  public BusinessLogicException(ResponseCode responseCode) {
    super();
    this.setCode(responseCode.getCode());
    this.setMessage(responseCode.getMessage());
  }

  @Override
  public String getMessage() {
    return message;
  }

}
