package com.cristian.accounts.infrastructure.mapper;

import com.cristian.accounts.domain.accounts.model.PhoneNumber;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PhoneMapper {

  public String asString(PhoneNumber phone) {
    if (Objects.isNull(phone)) {
      return null;
    }

    return phone.getText();
  }
}
