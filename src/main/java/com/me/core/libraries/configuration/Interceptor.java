package com.me.core.libraries.configuration;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.me.core.constant.fields.BaseMongoFields;
import com.me.core.model.request.MandatoryRequest;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.logging.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class Interceptor extends HandlerInterceptorAdapter {

  private static final String[] exclude = new String[]{
      "/swagger-ui.html", "/swagger-resources/configuration/ui",
      "/swagger-resources/configuration/security",
      "/swagger-resources", "/", "/error", "/csrf", "/error",
      "/me-core/user/register"
  };

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
      Object handler) {
    if (Arrays.stream(exclude).noneMatch(s -> s.equals(request.getRequestURI()))) {
      String authorization = request.getHeader("Authorization");
      String email = "";
      if (Objects.nonNull(authorization)) {
        String token = authorization.split(" ")[1];
        DecodedJWT decode = JWT.decode(token);

        Map<String, Claim> claims = decode.getClaims();

        Claim claimEmail = claims.get("email");

        email = String.valueOf(claimEmail.asString());
      }

      MandatoryRequest mandatoryRequest = MandatoryRequest.builder()
          .storeId(request.getHeader("storeId"))
          .channelId(request.getHeader("channelId"))
          .username(request.getHeader("username"))
          .requestId(request.getHeader("requestId"))
          .serviceId(request.getHeader("serviceId"))
          .email(email)
          .build();

      MDC.put("mandatoryRequest", mandatoryRequest);
      MDC.put(BaseMongoFields.STORE_ID, request.getHeader("storeId"));
      MDC.put(BaseMongoFields.CHANNEL_ID, request.getHeader("channelId"));
      MDC.put(BaseMongoFields.USERNAME, request.getHeader("username"));
      MDC.put(BaseMongoFields.REQUEST_ID, request.getHeader("requestId"));
      MDC.put(BaseMongoFields.SERVICE_ID, request.getHeader("serviceId"));
      MDC.put("email", email);

      request.setAttribute("mandatory", mandatoryRequest);
    }
    return true;
  }
}
