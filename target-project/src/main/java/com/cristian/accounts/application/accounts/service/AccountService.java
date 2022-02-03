package com.cristian.accounts.application.accounts.service;

import com.cristian.accounts.domain.accounts.command.CreateAccountCommand;
import com.cristian.accounts.domain.accounts.command.UpdateAccountCommand;
import com.cristian.accounts.domain.accounts.model.Account;
import com.sun.istack.NotNull;

import java.util.Optional;
import java.util.UUID;

public interface AccountService {

  Optional<Account> find(final UUID id);

  Account create(final CreateAccountCommand ac);

  Account update(final UpdateAccountCommand ac);

  void delete(@NotNull final UUID id);
}
