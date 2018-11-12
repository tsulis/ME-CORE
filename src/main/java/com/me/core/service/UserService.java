package com.me.core.service;

import com.me.core.entity.User;
import com.me.core.model.request.MandatoryRequest;
import com.me.core.model.request.UpdateRequest;
import com.me.core.model.request.UserRequest;
import com.me.core.model.request.VerificationRequest;
import com.me.core.model.response.RegisterResponse;
import com.me.core.model.response.UpdateResponse;
import com.me.core.model.response.VerificationResponse;
import reactor.core.publisher.Mono;

public interface UserService {

  Mono<RegisterResponse> register(UserRequest userRequest);

  Mono<VerificationResponse> verification(MandatoryRequest mandatoryRequest, VerificationRequest verificationRequest);

  Mono<User> create(User user);

  Mono<UpdateResponse> update(MandatoryRequest mandatoryRequest, UpdateRequest updateRequest);
}
