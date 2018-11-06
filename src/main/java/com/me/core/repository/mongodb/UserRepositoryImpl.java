package com.me.core.repository.mongodb;

import com.me.core.entity.User;
import com.me.core.repository.UserRepositoryCustom;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

  @Autowired
  ReactiveMongoTemplate reactiveMongoTemplate;

  @Override
  public Mono<UpdateResult> logout(String email) {

    Criteria criteria = Criteria.where("email").is(email);

    Query query = new Query();
    query.addCriteria(criteria);

    Update update = new Update();
    update.set("isLogin", false);

    return reactiveMongoTemplate.updateFirst(query, update, User.class);
  }
}
