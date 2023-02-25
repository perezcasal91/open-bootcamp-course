package com.perezcasal.designpatterns.patterns.behavioral.chain.filter.processor;

import com.perezcasal.designpatterns.patterns.behavioral.chain.filter.provider.AuthenticationProvider;
import com.perezcasal.designpatterns.patterns.behavioral.chain.filter.provider.CSRFProvider;

public class CSRFProcessor extends AuthenticationProcessor {
    public CSRFProcessor(AuthenticationProcessor processor) {
        super(processor);
    }

    @Override
    public boolean isAuthenticated(AuthenticationProvider provider) {
        if (provider instanceof CSRFProvider) {
            System.out.println("CSRFProcessor is authenticated: " + provider.provider());
            return true;
        }
        return false;
    }
}
