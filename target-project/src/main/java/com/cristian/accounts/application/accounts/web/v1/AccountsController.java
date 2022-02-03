package com.cristian.accounts.application.accounts.web.v1;

import com.cristian.accounts.application.accounts.service.AccountService;
import com.cristian.accounts.infrastructure.mapper.UuidMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/accounts")
@RestController
@RequiredArgsConstructor
public class AccountsController {

  private final AccountsApiResponse apiResponse;
  private final AccountsApiRequests apiRequests;
  private final AccountService accountService;
  private final UuidMapper uuidMapper;

  @PostMapping
  public ResponseEntity<AccountsApiResponse.AccountDetailed> create(
      @Valid @RequestBody AccountsApiRequests.CreateAccount request) {
    var command = apiRequests.createAccountCommand(request);
    var account = accountService.create(command);
    return ResponseEntity.ok(apiResponse.accountDetailed(account));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<AccountsApiResponse.AccountDetailed> update(
      @Valid @RequestBody AccountsApiRequests.UpdateAccount request, @PathVariable String id) {
    var command = apiRequests.updateAccountCommand(request, id);
    var account = accountService.update(command);
    return ResponseEntity.ok(apiResponse.accountDetailed(account));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    accountService.delete(uuidMapper.uuid(id));
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<AccountsApiResponse.AccountDetailed> find(@PathVariable String id) {
    var account = accountService.find(uuidMapper.uuid(id));

    if (account.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(apiResponse.accountDetailed(account.get()));
  }
}
