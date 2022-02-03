package com.cristian.accounts.domain.accounts.model;

public interface EntityFactory<T, I> {
  I generateIdentity();
}
