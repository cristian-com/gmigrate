package com.cristian.accounts.domain.accounts.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.Set;
import java.util.UUID;

@Getter
@Builder(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Organization {
  private final UUID id;
  @NotEmpty private final String name;
  @Singular private final Set<CustomFieldDefinition> customFields;
}
