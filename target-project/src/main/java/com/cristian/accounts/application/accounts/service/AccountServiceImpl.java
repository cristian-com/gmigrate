package com.cristian.accounts.application.accounts.service;

import com.cristian.accounts.domain.accounts.command.CreateAccountCommand;
import com.cristian.accounts.domain.accounts.command.UpdateAccountCommand;
import com.cristian.accounts.domain.accounts.model.Account;
import com.cristian.accounts.domain.accounts.model.AccountFactory;
import com.cristian.accounts.domain.accounts.model.EmailAddress;
import com.cristian.accounts.domain.accounts.model.PhoneNumber;
import com.cristian.accounts.domain.accounts.repository.AccountRepository;
import com.cristian.accounts.domain.accounts.service.Event;
import com.cristian.accounts.domain.accounts.service.EventService;
import com.cristian.accounts.infrastructure.validation.AggregateNotFoundException;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

  private final AccountFactory accountFactory;
  private final AccountRepository accountRepository;
  private final EventService eventService;

  @Override
  public Optional<Account> find(@NotNull final UUID id) {
    requireNonNull(id);
    return accountRepository.find(id);
  }

  @Override
  public Account create(@NotNull final CreateAccountCommand command) {
    requireNonNull(command);
    var account = accountFactory.newInstance(command);
    eventService.publish(new Event());
    return accountRepository.save(account);
  }

  @Override
  public Account update(@NotNull final UpdateAccountCommand command) {
    requireNonNull(command);
    var account =
        accountRepository
            .find(command.getId())
            .orElseThrow(() -> new AggregateNotFoundException(""));

    if (nonNull(command.getName())) account.setName(command.getName());
    if (nonNull(command.getEmail())) account.setEmail(EmailAddress.of(command.getEmail()));
    if (nonNull(command.getPhone())) account.setPhone(PhoneNumber.of(command.getPhone()));
    if (nonNull(command.getSurname())) account.setName(command.getSurname());

    accountRepository.save(account);

    return account;
  }

  @Override
  public void delete(@NotNull final UUID id) {
    requireNonNull(id);
    accountRepository.delete(id);
  }
}
