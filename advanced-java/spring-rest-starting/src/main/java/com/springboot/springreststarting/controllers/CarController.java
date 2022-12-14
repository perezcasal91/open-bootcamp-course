package com.springboot.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.springframework.stereotype.Component;

@Path("/")
@Component
public class CarController {
    @GET
    @Path("/")
    public String hello(){
        return "Hello";
    }
}
