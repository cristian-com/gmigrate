package com.cristian.accounts.domain.accounts.model;

import lombok.Builder;

import java.util.Map;

@Builder
public class Member {
  private final Account account;
  private final String organizationId;
  private final Map<CustomFieldDefinition, Object> customFields;

  public Object getCustomFieldValue(final CustomFieldDefinition fieldDefinition) {
    return customFields.get(fieldDefinition);
  }
}
