package com.cristian.accounts.infrastructure.mapper;

import com.cristian.accounts.domain.accounts.model.EmailAddress;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class EmailMapper {

  public String asString(EmailAddress email) {
    if (Objects.isNull(email)) {
      return null;
    }

    return email.getText();
  }
}
