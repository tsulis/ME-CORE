package com.me.core.service.impl;

import com.me.core.entity.User;
import com.me.core.model.dto.UserDTO;
import com.me.core.model.request.MandatoryRequest;
import com.me.core.model.request.UserRequest;
import com.me.core.model.request.VerificationRequest;
import com.me.core.model.response.RegisterResponse;
import com.me.core.model.response.VerificationResponse;
import com.me.core.repository.UserRepository;
import com.me.core.service.AuthService;
import com.me.core.service.EmailService;
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

  @Autowired
  EmailService emailService;

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

            emailService.sendMail(user);

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
  public Mono<VerificationResponse> verification(MandatoryRequest mandatoryRequest, VerificationRequest verificationRequest) {
    return Mono.defer(() -> {
      String email = mandatoryRequest.getEmail();
      int vCode = verificationRequest.getVCode();

      return userRepository.findByEmailAndVerificationCode(email, vCode)
          .flatMap(user -> {
            user.setEnabled(true);
            userRepository.save(user);

            return Mono.just(VerificationResponse.builder()
                .user(UserDTO.builder()
                    .email(user.getEmail())
                    .fullName(user.getFullName())
                    .enabled(user.isEnabled())
                    .build())
                .build());
          })
          .switchIfEmpty(Mono.error(new ExceptionInInitializerError("Invalid Request")));
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
