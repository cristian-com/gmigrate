package com.cristian.accounts.domain.accounts.command;

import lombok.*;

import java.util.UUID;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class UpdateAccountCommand extends Command {
  UUID id;
  String name;
  String email;
  String surname;
  String phone;
}
