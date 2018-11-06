package com.me.core.libraries.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

  private static final String STRING = "string";
  private static final String HEADER = "header";
//  private static final String USERNAME = "username";

  @Bean
  public Docket init() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.me.core.controller"))
        .paths(regex("/.*"))
        .build()
        .globalOperationParameters(Arrays.asList(
            new ParameterBuilder().name("Authorization").parameterType(HEADER)
                .modelRef(new ModelRef(STRING)).required(true).defaultValue("")
                .description("client's Authorization").build()
        ))
//        .globalOperationParameters(Arrays.asList(
//            new ParameterBuilder().name("storeId").parameterType(HEADER)
//                .modelRef(new ModelRef(STRING)).required(true).defaultValue("")
//                .description("client's store id").build(),
//            new ParameterBuilder().name("channelId").parameterType(HEADER)
//                .modelRef(new ModelRef(STRING)).required(true).defaultValue("WEB")
//                .description("client's channel id").build(),
//            new ParameterBuilder().name("requestId").parameterType(HEADER)
//                .modelRef(new ModelRef(STRING)).required(true).defaultValue("23123123")
//                .description("client's request Id").build(),
//            new ParameterBuilder().name("serviceId").parameterType(HEADER)
//                .modelRef(new ModelRef(STRING)).required(true).defaultValue("gateway")
//                .description("client's serviceId").build(),
//            new ParameterBuilder().name(USERNAME).parameterType(HEADER)
//                .modelRef(new ModelRef(STRING)).required(true).defaultValue(USERNAME)
//                .description("username").build()))
        .genericModelSubstitutes(DeferredResult.class, ResponseEntity.class);
  }

//  @Bean
//  UiConfiguration uiConfig() {
//    return UiConfigurationBuilder.builder()
//        .displayRequestDuration(true)
//        .validatorUrl(null)
//        .build();
//  }
}
