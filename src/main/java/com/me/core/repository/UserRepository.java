package com.me.core.repository;

import com.me.core.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String>, UserRepositoryCustom {

  Mono<User> findByEmail(String email);
  Mono<User> findByEmailAndVerificationCode(String email, int vCode);

}
