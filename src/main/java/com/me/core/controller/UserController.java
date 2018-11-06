package com.me.core.controller;

import com.me.core.constant.ApiPath;
import com.me.core.constant.enums.ResponseCode;
import com.me.core.model.request.UserRequest;
import com.me.core.model.response.BaseResponse;
import com.me.core.model.response.CommonResponse;
import com.me.core.service.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@RestController
@Api(value = "User")
@RequestMapping(value = ApiPath.USER)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping(value = ApiPath.APPEND_REGISTER)
  public Mono register(@RequestBody UserRequest userRequest){
    return Mono.defer(() -> {
      return userService.register(userRequest)
          .map(registerResponse -> {
            return CommonResponse.constructResponse(ResponseCode.SUCCESS, registerResponse);
          });
    }).subscribeOn(Schedulers.elastic());
  }

}
