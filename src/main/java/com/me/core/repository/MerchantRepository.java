package com.me.core.repository;

import com.me.core.entity.merchant.Merchant;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface MerchantRepository extends ReactiveMongoRepository<Merchant, String>, MerchantRepositoryCustom {

  Mono<Merchant> findByIdAndIsDeleted(String id, boolean deleted);
}
