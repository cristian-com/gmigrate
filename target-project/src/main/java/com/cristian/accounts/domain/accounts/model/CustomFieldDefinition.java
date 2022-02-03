package com.cristian.accounts.domain.accounts.model;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode(of = "name")
public abstract class CustomFieldDefinition {
  @NotNull private final String name;
  private final FieldType fieldType;
}
