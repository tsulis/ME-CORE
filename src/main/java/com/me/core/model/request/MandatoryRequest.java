package com.me.core.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MandatoryRequest {

  private String storeId;

  private String channelId;

  private String requestId;

  private String serviceId;

  private String username;

  private String email;

}
