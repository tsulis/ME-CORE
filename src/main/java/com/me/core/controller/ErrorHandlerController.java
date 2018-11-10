package com.me.core.controller;

import com.me.core.constant.enums.ResponseCode;
import com.me.core.libraries.exception.BusinessLogicException;
import com.me.core.model.response.BaseResponse;
import com.me.core.model.response.CommonResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springfox.documentation.annotations.ApiIgnore;

@Slf4j
@ApiIgnore
@RestControllerAdvice
public class ErrorHandlerController {

  @ExceptionHandler(BindException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public BaseResponse bindException(BindException be) {
    log.info("BindException = {}", be);
    List<FieldError> bindErrors = be.getFieldErrors();
    List<String> errors = new ArrayList<>();
    for(FieldError fieldError : bindErrors) {
      errors.add(fieldError.getField() + " " + fieldError.getDefaultMessage());
    }

    return CommonResponse.constructResponse(ResponseCode.BIND_ERROR, errors, null);
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public BaseResponse exception(Exception e) {
    log.warn("Exception = {}", e);
    return CommonResponse.constructResponse(ResponseCode.SYSTEM_ERROR,null, null);
  }

  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public BaseResponse runTimeException(RuntimeException re) {
    log.info("Runtime Error = {}", re);
    return CommonResponse.constructResponse(ResponseCode.RUNTIME_ERROR,null, null);
  }

  @ExceptionHandler(BusinessLogicException.class)
  public BaseResponse businessLogicException(BusinessLogicException ble) {
    log.info("BusinessLogicException = {}", ble);
    return CommonResponse.constructResponse(ble, null, null);
  }
}
