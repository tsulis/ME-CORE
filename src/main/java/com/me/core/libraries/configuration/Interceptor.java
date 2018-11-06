package com.me.core.libraries.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.logging.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class Interceptor extends HandlerInterceptorAdapter {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//    MandatoryRequest mandatoryRequest = new MandatoryRequestBuilder()
//        .withStoreId(request.getHeader("storeId"))
//        .withChannelId(request.getHeader("channelId"))
//        .withUsername(request.getHeader("username"))
//        .withRequestId(request.getHeader("requestId"))
//        .withServiceId(request.getHeader("serviceId")).build();
//
//    MDC.put("mandatoryRequest", mandatoryRequest);
//    MDC.put(BaseMongoFields.STORE_ID, request.getHeader("storeId"));
//    MDC.put(BaseMongoFields.CHANNEL_ID, request.getHeader("channelId"));
//    MDC.put(BaseMongoFields.USERNAME, request.getHeader("username"));
//    MDC.put(BaseMongoFields.REQUEST_ID, request.getHeader("requestId"));
//    MDC.put(BaseMongoFields.SERVICE_ID, request.getHeader("serviceId"));
//
//    request.setAttribute("mandatory", mandatoryRequest);

    return true;
  }
}
