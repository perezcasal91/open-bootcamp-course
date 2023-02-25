package com.perezcasal.designpatterns.patterns.behavioral.chain.filter.processor;

import com.perezcasal.designpatterns.patterns.behavioral.chain.filter.provider.AuthenticationProvider;
import com.perezcasal.designpatterns.patterns.behavioral.chain.filter.provider.OAuthProvider;

public class OAuthProcessor  extends AuthenticationProcessor {

    public OAuthProcessor(AuthenticationProcessor processor) {
        super(processor);
    }

    @Override
    public boolean isAuthenticated(AuthenticationProvider provider) {
        if (provider instanceof OAuthProvider) {
            System.out.println("OAuthProcessor is authenticated: " + provider.provider());
            return true;
        }
        return false;
    }
}
