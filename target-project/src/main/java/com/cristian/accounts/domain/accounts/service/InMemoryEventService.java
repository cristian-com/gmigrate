package com.cristian.accounts.domain.accounts.service;

public class InMemoryEventService implements EventService {

  @Override
  public void publish(Event event) {
    System.out.println("Hello ----------------- World");
  }
}
