package com.cristian.accounts.infrastructure.validation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public @interface CommandBean {}
