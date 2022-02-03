package com.cristian.accounts.domain.accounts.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;

import static com.cristian.accounts.infrastructure.validation.Strings.requiresNonBlank;
import static java.util.Objects.requireNonNull;

@Data
public class Account {
  private final UUID identity;
  private EmailAddress email;
  private String name;
  private String surname;
  private PhoneNumber phone;
  private Set<ContactDetail> contactDetails;

  @Builder
  private Account(
      @NotNull UUID identity,
      @NotNull EmailAddress email,
      @NotBlank String name,
      String surname,
      PhoneNumber phone,
      Set<ContactDetail> contactDetails) {
    requireNonNull(identity);

    this.identity = identity;
    this.surname = surname;
    this.phone = phone;
    setName(name);
    setEmail(email);
    setContactDetails(contactDetails);
  }

  public void setName(@NotBlank String name) {
    requiresNonBlank(name);
    this.name = name;
  }

  public void setEmail(@NotNull EmailAddress email) {
    requireNonNull(email);
    this.email = email;
  }

  public void setContactDetails(final Set<ContactDetail> par) {
    var contactDetails = par;

    if (Objects.isNull(contactDetails)) {
      contactDetails = new HashSet<>();
    }

    contactDetails.add(email);

    if (Objects.nonNull(phone)) {
      contactDetails.add(phone);
    }

    this.contactDetails = Collections.unmodifiableSet(contactDetails);
  }
}
