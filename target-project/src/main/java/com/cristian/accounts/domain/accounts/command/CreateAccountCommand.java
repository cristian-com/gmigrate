package com.cristian.accounts.domain.accounts.command;

import lombok.*;

import java.util.Map;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class CreateAccountCommand extends Command {
  String name;
  String email;
  String surname;
  String phone;
  Map<String, String> contactDetails;
}
