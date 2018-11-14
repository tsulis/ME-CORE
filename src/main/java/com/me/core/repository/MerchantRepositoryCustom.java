package com.me.core.repository;

import com.me.core.entity.merchant.Merchant;
import com.me.core.libraries.wrapper.PageWrapper;
import com.me.core.model.request.MandatoryRequest;
import java.util.Date;
import org.springframework.data.domain.PageRequest;
import reactor.core.publisher.Mono;

public interface MerchantRepositoryCustom {

  Mono<PageWrapper<Merchant>> search(
      MandatoryRequest mandatoryRequest,
      String email, String name, Date dob, String phone,
      String address, String type, PageRequest pageRequest
  );
}
