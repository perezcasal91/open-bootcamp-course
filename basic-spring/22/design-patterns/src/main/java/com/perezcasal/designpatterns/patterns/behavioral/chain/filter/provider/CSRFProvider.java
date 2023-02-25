package com.perezcasal.designpatterns.patterns.behavioral.chain.filter.provider;

public record CSRFProvider(String provider) implements AuthenticationProvider {

}
