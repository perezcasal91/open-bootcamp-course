package com.perezcasal.designpatterns.patterns.behavioral.chain.filter.provider;

public record OAuthProvider(String provider) implements AuthenticationProvider {

}
