package com.me.core.libraries.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("markup.mongodb.reactive.mongo")
public class MongodbReactiveMongoProperties {

  private Integer connectionPerHost;
  private Integer minConnectionsPerHost;
  private Integer threadsAllowedToBlockForConnectionMultiplier;
  private Integer connectTimeout;
  private Integer maxWaitTime;
  private Integer socketTimeout;
  private Integer heartbeatConnectTimeout;
  private Integer heartbeatFrequency;
  private Integer heartbeatSocketTimeout;
  private Integer maxConnectionIdleTime;
  private Integer maxConnectionLifeTime;
  private Integer minHeartbeatFrequency;
  private String readPreference;
  private Integer writeNumber;
}
