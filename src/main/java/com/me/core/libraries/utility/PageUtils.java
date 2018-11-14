package com.me.core.libraries.utility;

import com.me.core.libraries.wrapper.PageImplWrapper;
import com.me.core.libraries.wrapper.PageWrapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.MutablePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jeffry Christian
 * @version 2.1.2
 * @since 2.1.2 (8 Nov 2018)
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PageUtils {

  private final ReactiveMongoTemplate reactiveMongoTemplate;

  public <T> Mono<PageWrapper<T>> toMonoPage(Query query, Pageable pageable, Class<T> clazz) {
    return reactiveMongoTemplate.count(
        query, clazz
    ).map(aLong -> new MutablePair<List<T>, Long>(null, aLong)
    ).flatMap(pair ->
        reactiveMongoTemplate.find(query, clazz).collectList().map(list -> {
              pair.setLeft(list);
              return pair;
            }
        ).flatMap(mutable ->
            Mono.just((PageWrapper<T>) new PageImplWrapper<>(mutable.getLeft(), pageable,
                mutable.getRight()))));
  }
}
