package com.perezcasal;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
    public HelloWorld() {
        System.out.println("Since we are here, let's said Hi.");
    }
    public String helloWorld() {
        return "Hello World";
    }
}
