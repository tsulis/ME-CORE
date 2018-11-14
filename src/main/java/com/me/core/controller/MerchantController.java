package com.me.core.controller;

import com.me.core.constant.ApiPath;
import com.me.core.constant.DefaultValues;
import com.me.core.constant.enums.ResponseCode;
import com.me.core.model.request.MandatoryRequest;
import com.me.core.model.request.MerchantRequest;
import com.me.core.model.response.CommonResponse;
import com.me.core.service.MerchantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import springfox.documentation.annotations.ApiIgnore;

@Slf4j
@RestController
@Api(value = "Merchant")
@RequestMapping(value = ApiPath.MERCHANT)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MerchantController {

  private final MerchantService merchantService;

  @PostMapping
  @ApiOperation(value = "POST.create", notes = "-")
  public Mono create(
      @ApiIgnore @ModelAttribute MandatoryRequest mandatoryRequest,
      @RequestBody MerchantRequest merchantRequest){
    return Mono.defer(() -> {
      return merchantService.create(mandatoryRequest, merchantRequest)
          .map(merchantResponse -> CommonResponse.constructResponse(ResponseCode.SUCCESS, merchantResponse));
    }).subscribeOn(Schedulers.elastic());
  }

  @GetMapping
  @ApiOperation(value = "GET.search", notes = "-")
  public Mono search(
      @ApiIgnore @ModelAttribute MandatoryRequest mandatoryRequest,
      @RequestParam(required = false) String email,
      @RequestParam(required = false, defaultValue = "") String name,
      @RequestParam(required = false) Date dob,
      @RequestParam(required = false) String phone,
      @RequestParam(required = false) String address,
      @RequestParam(required = false) String type,
      @RequestParam(required = false, name = "page", defaultValue = DefaultValues.STR_PAGE) int page,
      @RequestParam(required = false, name = "size", defaultValue = DefaultValues.STR_PAGE_SIZE) int size,
      @RequestParam(required = false, value = "sort", defaultValue = "ASC") Direction sortDirection) {
    return Mono.defer(() -> {
      return merchantService.search(mandatoryRequest, email, name, dob, phone, address, type, page, size, sortDirection)
          .map(merchantResponse -> CommonResponse.constructResponse(ResponseCode.SUCCESS, merchantResponse));
    }).subscribeOn(Schedulers.elastic());
  }

  @PutMapping("{id}")
  @ApiOperation(value = "PUT.update", notes = "-")
  public Mono update(
      @ApiIgnore @ModelAttribute MandatoryRequest mandatoryRequest,
      @RequestBody MerchantRequest merchantRequest,
      @PathVariable String id){
    return Mono.defer(() -> {
      return merchantService.update(mandatoryRequest, merchantRequest, id)
          .map(merchantResponse -> CommonResponse.constructResponse(ResponseCode.SUCCESS, merchantResponse));
    }).subscribeOn(Schedulers.elastic());
  }

  @DeleteMapping("{id}")
  @ApiOperation(value = "DELETE.delete", notes = "-")
  public Mono delete(
      @ApiIgnore @ModelAttribute MandatoryRequest mandatoryRequest,
      @PathVariable String id){
    return Mono.defer(() -> {
      return merchantService.delete(mandatoryRequest, id)
          .map(merchantResponse -> CommonResponse.constructResponse(ResponseCode.SUCCESS, merchantResponse));
    }).subscribeOn(Schedulers.elastic());
  }

}
