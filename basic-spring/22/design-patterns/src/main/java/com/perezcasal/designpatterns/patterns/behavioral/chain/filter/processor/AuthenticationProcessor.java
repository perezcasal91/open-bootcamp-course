package com.perezcasal.designpatterns.patterns.behavioral.chain.filter.processor;

import com.perezcasal.designpatterns.patterns.behavioral.chain.filter.provider.AuthenticationProvider;

public abstract class AuthenticationProcessor {

    protected AuthenticationProcessor nextProcessor;

    public AuthenticationProcessor(AuthenticationProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public abstract boolean isAuthenticated(AuthenticationProvider provider);
}
