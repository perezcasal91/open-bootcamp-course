package com.perezcasal;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    private final HelloWorld helloWorld;

    public HelloWorldService(HelloWorld helloWorld) {
        System.out.println("Since we are here, let's service.");
        this.helloWorld = helloWorld;
    }

    public String hi() {
        return helloWorld.helloWorld();
    }
}
