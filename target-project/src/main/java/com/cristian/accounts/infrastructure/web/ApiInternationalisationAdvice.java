package com.cristian.accounts.infrastructure.web;

import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import static java.util.Objects.isNull;

@ControllerAdvice
@RequiredArgsConstructor
public class ApiInternationalisationAdvice implements ResponseBodyAdvice<Object> {

  private final ResourceBundleMessageSource resourceBundleMessageSource;

  public boolean supports(
      MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
    return AbstractJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
  }

  @Override
  public Object beforeBodyWrite(
      Object body,
      MethodParameter methodParameter,
      MediaType mediaType,
      Class<? extends HttpMessageConverter<?>> aClass,
      ServerHttpRequest serverHttpRequest,
      ServerHttpResponse serverHttpResponse) {

    if (isNull(body)) {
      return null;
    }

    if (ApiResponse.class.isAssignableFrom(body.getClass())) {
      var response = (ApiResponse<?>) body;
      var translatedMessage =
          resourceBundleMessageSource.getMessage(
              response.getMessage(), response.getMessageParams(), LocaleContextHolder.getLocale());
      response.setMessage(translatedMessage);

      return response;
    }

    return body;
  }
}
