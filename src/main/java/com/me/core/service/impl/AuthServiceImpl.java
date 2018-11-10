package com.me.core.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.me.core.model.dto.UserDTO;
import com.me.core.model.request.AuthRequest;
import com.me.core.model.response.AuthResponse;
import com.me.core.repository.UserRepository;
import com.me.core.service.AuthService;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  UserRepository userRepository;

  @Override
  public Mono<AuthResponse> login(AuthRequest authRequest) {
    return Mono.defer(() -> userRepository.findByEmail(authRequest.getEmail())
        .flatMap(user -> {

          String hashpw = BCrypt.hashpw(authRequest.getPassword(), user.getSalt());

          if (!user.getPassword().equals(hashpw)) {
            throw new ExceptionInInitializerError("Invalid Password");
          }

          String token =
              generateToken(authRequest.getEmail(), user.getFullName(),
                  DateUtils.addHours(new Date(), 1));

          return Mono.just(AuthResponse.builder()
              .user(UserDTO.builder()
                  .email(user.getEmail())
                  .fullName(user.getFullName())
                  .enabled(user.isEnabled())
                  .build())
              .token(token)
              .build());
        })
        .switchIfEmpty(Mono.error(new ExceptionInInitializerError("Invalid Request")))).subscribeOn(Schedulers.elastic());
  }

  @Override
  public Mono<Boolean> logout(HttpServletRequest servletRequest) {
    String authorization = servletRequest.getHeader("Authorization");
    String token = authorization.split(" ")[1];
    DecodedJWT decode = JWT.decode(token);

    Map<String, Claim> claims = decode.getClaims();

    Claim claimEmail = claims.get("email");

    String email = String.valueOf(claimEmail.asString());

    return userRepository.logout(email).flatMap(updateResult ->
        Mono.just(updateResult.wasAcknowledged())).switchIfEmpty(Mono.just(false));
  }

  @Override
  public Mono<String> refreshToken(String token) {
    return Mono.defer(() -> {
      DecodedJWT decode = JWT.decode(token);
      Map<String, Claim> claims = decode.getClaims();
      Date expiresAt = decode.getExpiresAt();
      Instant instantExpireAt = expiresAt.toInstant();

      Date date = DateUtils.addHours(new Date(), 1);
      Instant instant = date.toInstant();

      Duration duration = Duration.between(
          instant.atZone(ZoneId.systemDefault()).toLocalDateTime(),
          instantExpireAt.atZone(ZoneId.systemDefault()).toLocalDateTime()
      );

      long diff = Math.abs(duration.toMinutes());

      if (diff <= 10) {
        return Mono.just(generateToken(
            String.valueOf(claims.get("email")),
            String.valueOf(claims.get("fullName")),
            DateUtils.addHours(new Date(), 1)
        ));
      }

      return Mono.just(token);
    }).subscribeOn(Schedulers.elastic());
  }

  @Override
  public String generateToken(String email, String fullName, Date expired) {
    return JWT.create()
        .withClaim("email", email)
        .withClaim("fullName", fullName)
        .withExpiresAt(expired)
        .sign(Algorithm.none());
  }
}
