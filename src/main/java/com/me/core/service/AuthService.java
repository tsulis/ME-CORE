package com.me.core.service;

import com.me.core.model.request.AuthRequest;
import com.me.core.model.response.AuthResponse;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import reactor.core.publisher.Mono;

public interface AuthService {

  Mono<AuthResponse> login(AuthRequest authRequest);

  Mono<Boolean> logout(HttpServletRequest servletRequest);

  Mono<String> refreshToken(String token);

  String generateToken(String email, String fullName, Date expired);
}
