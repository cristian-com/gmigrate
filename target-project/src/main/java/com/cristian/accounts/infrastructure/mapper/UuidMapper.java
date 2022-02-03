package com.cristian.accounts.infrastructure.mapper;

import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class UuidMapper {

  public UUID uuid(String str) {
    if (Objects.isNull(str)) {
      return null;
    }

    try {
      return UUID.fromString(str);
    } catch (IllegalArgumentException e) {
      return null;
    }
  }

  public String asString(UUID uuid) {
    if (Objects.isNull(uuid)) {
      return null;
    }

    return uuid.toString();
  }
}
