package com.me.core.service;

import com.me.core.entity.User;
import com.me.core.model.request.UserRequest;
import com.me.core.model.response.RegisterResponse;
import reactor.core.publisher.Mono;

public interface UserService {

  Mono<RegisterResponse> register(UserRequest userRequest);

  Mono<User> create(User user);
}
