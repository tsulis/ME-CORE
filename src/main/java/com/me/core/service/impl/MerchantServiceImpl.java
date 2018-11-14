package com.me.core.service.impl;

import com.me.core.constant.DefaultValues;
import com.me.core.constant.enums.ResponseCode;
import com.me.core.constant.fields.BaseMongoFields;
import com.me.core.entity.merchant.Merchant;
import com.me.core.libraries.exception.BusinessLogicException;
import com.me.core.libraries.utility.BeanMapper;
import com.me.core.libraries.wrapper.PageImplWrapper;
import com.me.core.libraries.wrapper.PageWrapper;
import com.me.core.model.request.MandatoryRequest;
import com.me.core.model.request.MerchantRequest;
import com.me.core.model.response.MerchantResponse;
import com.me.core.repository.MerchantRepository;
import com.me.core.service.MerchantService;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MerchantServiceImpl implements MerchantService {

  private final MerchantRepository merchantRepository;

  @Override
  public Mono<PageWrapper<MerchantResponse>> search(MandatoryRequest mandatoryRequest, String email,
      String name, Date dob, String phone, String address, String type, int page, int size, Direction direction) {
    PageRequest pageRequest = PageRequest.of(page, size, new Sort(direction, BaseMongoFields.CREATED_DATE));
    return Mono.defer(() -> {
      return merchantRepository.search(mandatoryRequest, email, name, dob, phone, address, type, pageRequest)
          .switchIfEmpty(Mono.error(new BusinessLogicException(ResponseCode.DATA_NOT_EXIST)))
          .map(merchants -> {
            return new PageImplWrapper<>(BeanMapper.mapAsList(merchants.getContent(), MerchantResponse.class), merchants.getPageable(), merchants.getTotalElements());
          });
    });
  }

  @Override
  public Mono<MerchantResponse> create(MandatoryRequest mandatoryRequest,
      MerchantRequest merchantRequest) {
    return Mono.defer(() -> {
      Merchant merchant = BeanMapper.map(merchantRequest, Merchant.class);
      String salt = BCrypt.gensalt();
      String hashPw = BCrypt.hashpw(merchant.getPassword(), salt);
      merchant.setSalt(salt);
      merchant.setPassword(hashPw);
      merchant.setDeleted(false);
      merchant.setEnabled(true);
      return merchantRepository.save(merchant)
          .map(m -> BeanMapper.map(m, MerchantResponse.class));
    });
  }

  @Override
  public Mono<MerchantResponse> update(MandatoryRequest mandatoryRequest,
      MerchantRequest request, String id) {
    return Mono.defer(() -> {
      return merchantRepository.findById(id)
          .flatMap(fm -> {
            Merchant update = Merchant.builder().build();
            BeanUtils.copyProperties(fm, update, Merchant.class);
            update.setEmail(request.getEmail());
            update.setName(request.getName());
            update.setDob(request.getDob());
            update.setPhone(request.getPhone());
            update.setAddress(request.getAddress());
            update.setType(request.getType());
            update.setPassword(request.getPassword());
            update.setUpdatedBy(mandatoryRequest.getUsername());
            update.setUpdatedDate(new Date());
            return merchantRepository.save(update);
          })
          .map(m -> BeanMapper.map(m, MerchantResponse.class));
    });
  }

  @Override
  public Mono<String> delete(MandatoryRequest mandatoryRequest, String id) {
    return Mono.defer(() -> {
      return merchantRepository.findByIdAndIsDeleted(id, false)
          .switchIfEmpty(Mono.error(new BusinessLogicException(ResponseCode.DATA_NOT_EXIST)))
          .flatMap(merchant -> {
            merchant.setDeleted(true);
            return merchantRepository.save(merchant)
                .map(m -> DefaultValues.SUCCESS);
          });
    });
  }
}
