package com.me.core.controller;

import com.me.core.constant.ApiPath;
import com.me.core.constant.enums.ResponseCode;
import com.me.core.model.request.AuthRequest;
import com.me.core.model.response.CommonResponse;
import com.me.core.service.AuthService;
import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@RestController
@Api(value = "User")
@RequestMapping(value = ApiPath.AUTH)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {

  @Autowired
  private AuthService authService;

  @PostMapping(value = ApiPath.APPEND_LOGIN)
  public Mono login(@RequestBody AuthRequest authRequest){
    return Mono.defer(() -> {
      return authService.login(authRequest)
          .map(authResponse -> {
            return CommonResponse.constructResponse(ResponseCode.SUCCESS, authResponse);
          });
    }).subscribeOn(Schedulers.elastic());
  }

  @GetMapping(value = ApiPath.APPEND_LOGOUT)
  public Mono logout(HttpServletRequest httpServletRequest){
    return Mono.defer(() -> {
      return authService.logout(httpServletRequest)
          .map(aBoolean -> {
            return CommonResponse.constructResponse(ResponseCode.SUCCESS, aBoolean);
          });
    }).subscribeOn(Schedulers.elastic());
  }


}
