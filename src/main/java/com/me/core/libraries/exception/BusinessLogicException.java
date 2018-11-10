package com.me.core.libraries.exception;

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

  @Override
  public String getMessage() {
    return message;
  }

}
