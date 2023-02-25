package com.perezcasal.designpatterns.patterns.behavioral.chain.filter.processor;

import com.perezcasal.designpatterns.patterns.behavioral.chain.filter.provider.JwtProvider;
import com.perezcasal.designpatterns.patterns.behavioral.chain.filter.provider.AuthenticationProvider;

public class JwtProcessor  extends AuthenticationProcessor {

    public JwtProcessor(AuthenticationProcessor processor) {
        super(processor);
    }

    @Override
    public boolean isAuthenticated(AuthenticationProvider provider) {
        if (provider instanceof JwtProvider) {
            System.out.println("JwtProcessor is authenticated: " + provider.provider());
            return true;
        }
        return false;
    }
}
