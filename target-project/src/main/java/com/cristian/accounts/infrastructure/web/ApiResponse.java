package com.cristian.accounts.infrastructure.web;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ApiResponse<T> implements Serializable {
  private String message;
  @JsonIgnore private Object[] messageParams;
  private T content;

  public ApiResponse(String message, T content) {
    this.message = message;
    this.content = content;
  }

  public ApiResponse(T content) {
    this.content = content;
  }
}
