package com.perezcasal.initspring.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    public HelloController(){}

    @GetMapping(value = "/api/hello")
    public String hi() {
        return "Hello";
    }
}
