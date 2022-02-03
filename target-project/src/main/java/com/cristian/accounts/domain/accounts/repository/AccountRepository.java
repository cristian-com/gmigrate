package com.cristian.accounts.domain.accounts.repository;

import com.cristian.accounts.domain.accounts.model.Account;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository {
  String aMethod();

  Optional<Account> find(final UUID id);

  Account save(final Account ac);

  void delete(final UUID id);
}
