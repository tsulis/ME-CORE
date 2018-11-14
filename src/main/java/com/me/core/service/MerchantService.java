package com.me.core.service;

import com.me.core.libraries.wrapper.PageWrapper;
import com.me.core.model.request.MandatoryRequest;
import com.me.core.model.request.MerchantRequest;
import com.me.core.model.response.MerchantResponse;
import java.util.Date;
import org.springframework.data.domain.Sort.Direction;
import reactor.core.publisher.Mono;

public interface MerchantService {

  Mono<PageWrapper<MerchantResponse>> search(MandatoryRequest mandatoryRequest, String email, String name, Date dob, String phone,
      String address, String type, int page, int size, Direction direction);

  Mono<MerchantResponse> create(MandatoryRequest mandatoryRequest, MerchantRequest merchantRequest);

  Mono<MerchantResponse> update(MandatoryRequest mandatoryRequest, MerchantRequest merchantRequest,
      String id);

  Mono<String> delete(MandatoryRequest mandatoryRequest, String id);
}
