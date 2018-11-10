package com.me.core.service.impl;

import com.me.core.entity.User;
import com.me.core.model.dto.UserDTO;
import com.me.core.model.request.UserRequest;
import com.me.core.model.response.RegisterResponse;
import com.me.core.repository.UserRepository;
import com.me.core.service.AuthService;
import com.me.core.service.UserService;
import java.util.Date;
import java.util.Random;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  AuthService authService;

  @Override
  public Mono<RegisterResponse> register(UserRequest userRequest) {
    return Mono.defer(() -> {
      final int vCode = new Random().nextInt(4);
      return create(User.userBuilder()
          .email(userRequest.getEmail())
          .fullName(userRequest.getFullName())
          .password(userRequest.getPassword())
          .verificationCode(vCode)
          .createdBy("SYSTEM")
          .enabled(false)
          .build())
          .flatMap(user -> {

            String token = authService.generateToken(
                user.getEmail(), user.getFullName(), DateUtils.addHours(new Date(), 1));

            //todo.. send verification code to email

            return Mono.just(RegisterResponse.builder()
                .token(token)
                .user(UserDTO.builder()
                    .fullName(user.getFullName())
                    .email(user.getEmail())
                    .enabled(user.isEnabled())
                    .build())
                .build());
          });
    }).subscribeOn(Schedulers.elastic());
  }

  @Override
  public Mono<User> create(User user) {
    return Mono.defer(() -> {
      String salt = BCrypt.gensalt();
      String hashpw = BCrypt.hashpw(user.getPassword(), salt);
      return userRepository.save(User.userBuilder()
          .isDeleted(false)
          .salt(salt)
          .password(hashpw)
          .email(user.getEmail())
          .fullName(user.getFullName())
          .createdBy(user.getCreatedBy())
          .createdDate(new Date())
          .enabled(user.isEnabled())
          .verificationCode(user.getVerificationCode())
          .build());
    }).subscribeOn(Schedulers.elastic());
  }
}
