package com.cristian.accounts.domain.accounts.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AccountValidator implements Validator {

  @Override
  public boolean supports(Class<?> aClass) {
    return Account.class.isAssignableFrom(aClass);
  }

  @Override
  public void validate(Object o, Errors errors) {
    ValidationUtils.rejectIfEmpty(errors, "name", "validation.field.required");

    Account account = (Account) o;

    if (account.getName().toUpperCase().startsWith("J")) {
      errors.rejectValue("name", "Don't use 'J' ffs");
    }
  }
}
