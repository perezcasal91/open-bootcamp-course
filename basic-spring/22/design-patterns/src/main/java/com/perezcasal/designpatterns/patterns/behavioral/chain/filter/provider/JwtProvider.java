package com.perezcasal.designpatterns.patterns.behavioral.chain.filter.provider;

public record JwtProvider(String provider) implements AuthenticationProvider {
}
