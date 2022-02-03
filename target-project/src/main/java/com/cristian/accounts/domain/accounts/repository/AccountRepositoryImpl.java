package com.cristian.accounts.domain.accounts.repository;

import com.cristian.accounts.domain.accounts.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

  // private final AccountDao accountDao;

  String variable;
  String anotherVariable;
  String thisVariable;
  String maMan;

  @Override
  public Optional<Account> find(UUID id) {
    return Optional.empty();
  }

  @Override
  public Account save(Account ac) {
    return null;
  }

  @Override
  public void delete(UUID id) {

  }

  // @Repository
  public interface AccountDao extends JpaRepository<Account, String> {}
}
