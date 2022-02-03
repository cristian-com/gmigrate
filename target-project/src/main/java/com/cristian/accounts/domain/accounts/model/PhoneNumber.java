package com.cristian.accounts.domain.accounts.model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.StringJoiner;

public class PhoneNumber implements ContactDetail {

  private final String code;
  private final String number;
  private final String fullNumber;

  public PhoneNumber(String code, String number) {
    this.code = code;
    this.number = number;
    this.fullNumber = format(code, number);
  }

  public static PhoneNumber of(@Valid @NotBlank String phoneNumber) {
    return new PhoneNumber("", "");
  }

  private String format(String code, String number) {
    return new StringJoiner(" ", "+", "").add(code).add(number).toString();
  }

  @Override
  public String getText() {
    return fullNumber;
  }
}
