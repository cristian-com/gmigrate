package com.cristian.accounts.domain.accounts.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventServiceConfiguration {

  @Bean
  InMemoryEventService inMemoryEventService() {
    return new InMemoryEventService();
  }
}
