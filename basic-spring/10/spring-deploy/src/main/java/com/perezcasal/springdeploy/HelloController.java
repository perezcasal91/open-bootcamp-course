package com.perezcasal.springdeploy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/api/")
public class HelloController {

    @Value("${app.user}")
    String user;
    @Value("${app.message}")
    String message;

    @GetMapping(value = "/hello")
    public String hello() {
        return user.toUpperCase(Locale.US) + " " + message;
    }
}
