package com.me.core.repository;

import com.mongodb.client.result.UpdateResult;
import reactor.core.publisher.Mono;

public interface UserRepositoryCustom {

  Mono<UpdateResult> logout(String email);

}
