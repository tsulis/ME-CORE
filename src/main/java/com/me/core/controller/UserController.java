package com.me.core.controller;

import com.me.core.constant.ApiPath;
import com.me.core.constant.enums.ResponseCode;
import com.me.core.model.request.MandatoryRequest;
import com.me.core.model.request.UserRequest;
import com.me.core.model.request.VerificationRequest;
import com.me.core.model.response.CommonResponse;
import com.me.core.service.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import springfox.documentation.annotations.ApiIgnore;

@Slf4j
@RestController
@Api(value = "User")
@RequestMapping(value = ApiPath.USER)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

  private final UserService userService;

  @PostMapping(value = ApiPath.APPEND_REGISTER)
  public Mono register(@ApiIgnore @ModelAttribute MandatoryRequest mandatoryRequest,
      @RequestBody UserRequest userRequest) {
    return Mono.defer(() -> {
      return userService.register(userRequest)
          .map(registerResponse -> {
            return CommonResponse.constructResponse(ResponseCode.SUCCESS, registerResponse);
          });
    }).subscribeOn(Schedulers.elastic());
  }

  @PostMapping(value = ApiPath.APPEND_VERIFICATION)
  public Mono verification(@ApiIgnore @ModelAttribute MandatoryRequest mandatoryRequest,
      @RequestHeader(value = "Authorization", required = true) String authorization,
      @RequestBody VerificationRequest verificationRequest){
    return Mono.defer(() -> {
      return userService.verification(mandatoryRequest, verificationRequest)
          .map(verificationResponse -> {
            return CommonResponse.constructResponse(ResponseCode.SUCCESS, verificationResponse);
          });
    }).subscribeOn(Schedulers.elastic());
  }

}
