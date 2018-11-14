package com.me.core.repository.mongodb;

import static org.apache.commons.lang3.StringUtils.isBlank;

import com.me.core.constant.fields.BaseMongoFields;
import com.me.core.constant.fields.MerchantFields;
import com.me.core.entity.merchant.Merchant;
import com.me.core.libraries.utility.PageUtils;
import com.me.core.libraries.wrapper.PageWrapper;
import com.me.core.model.request.MandatoryRequest;
import com.me.core.repository.MerchantRepositoryCustom;
import com.sun.deploy.net.proxy.pac.PACFunctions;
import java.util.Date;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MerchantRepositoryImpl implements MerchantRepositoryCustom {

  private final ReactiveMongoTemplate reactiveMongoTemplate;
  private final PageUtils pageUtils;

  @Override
  public Mono<PageWrapper<Merchant>> search(MandatoryRequest mandatoryRequest, String email,
      String name, Date dob, String phone, String address, String type, PageRequest pageRequest) {
    Query query = new Query();

    Criteria criteria = Criteria.where(BaseMongoFields.IS_DELETED).is(false);

    query.addCriteria(criteria);

    if (!isBlank(name)) {
      query.addCriteria(criteria.and(MerchantFields.NAME).regex(name, "i"));
    }

    if (!isBlank(email)) {
      query.addCriteria(criteria.and(MerchantFields.EMAIL).regex(email, "i"));
    }

    if (Objects.nonNull(dob)) {
      query.addCriteria(criteria.and(MerchantFields.DOB).is(dob));
    }

    if (!isBlank(phone)) {
      query.addCriteria(criteria.and(MerchantFields.PHONE).regex(phone, "i"));
    }

    if (!isBlank(address)) {
      query.addCriteria(criteria.and(MerchantFields.ADDRESS).regex(address, "i"));
    }

    if (!isBlank(type)) {
      query.addCriteria(criteria.and(MerchantFields.TYPE).is(type));
    }

    query.with(pageRequest);
    return pageUtils.toMonoPage(query, pageRequest, Merchant.class);
  }
}
