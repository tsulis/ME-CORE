package com.me.core.libraries.configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeserializationProblemHandler extends
    com.fasterxml.jackson.databind.deser.DeserializationProblemHandler {

  private static final Logger LOG = LoggerFactory.getLogger(DeserializationProblemHandler.class);

  @Override
  public boolean handleUnknownProperty(DeserializationContext ctxt, JsonParser jp,
      JsonDeserializer<?> deserializer, Object beanOrClass, String propertyName) {
    DeserializationProblemHandler.LOG.warn("unknown field : {}", propertyName);
    return true;
  }
}
