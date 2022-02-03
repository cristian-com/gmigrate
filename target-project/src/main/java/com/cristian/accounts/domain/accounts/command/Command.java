package com.cristian.accounts.domain.accounts.command;

import java.util.UUID;

public abstract class Command {
  protected UUID commandId = UUID.randomUUID();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Command other = (Command) o;
    return commandId.equals(other.commandId);
  }

  @Override
  public int hashCode() {
    return commandId.hashCode();
  }
}
