package com.cristian.accounts.domain.accounts.model;

import com.cristian.accounts.domain.accounts.command.CreateAccountCommand;
import com.cristian.accounts.infrastructure.validation.Factory;

import java.util.UUID;

@Factory
public class AccountFactory implements EntityFactory<Account, UUID> {

  public Account newInstance(CreateAccountCommand command) {
    return Account.builder()
        .identity(generateIdentity())
        .name(command.getName())
        .surname(command.getSurname())
        .email(EmailAddress.of(command.getEmail()))
        .phone(PhoneNumber.of(command.getPhone()))
        .build();
  }

  @Override
  public UUID generateIdentity() {
    return UUID.randomUUID();
  }
}
