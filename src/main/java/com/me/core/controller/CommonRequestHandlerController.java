package com.me.core.controller;

import com.me.core.model.request.MandatoryRequest;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestControllerAdvice
public class CommonRequestHandlerController {

  @ModelAttribute
  public MandatoryRequest getMandatoryParameter(HttpServletRequest request) {
    return (MandatoryRequest) request.getAttribute("mandatory");
  }

}
