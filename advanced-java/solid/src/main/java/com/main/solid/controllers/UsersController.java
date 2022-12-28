package com.main.solid.controllers;

import com.main.solid.entities.User;
import com.main.solid.services.UsersService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.ArrayList;

@Path("/")
@Component
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
        this.usersService.initDataBase(2);
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getAllUsers() {
        return this.usersService.getAll();
    }

    @GET
    @Path("/users/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("username") String username) {
        return this.usersService.get(username);
    }

    @POST
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {
        this.usersService.add(user);
        return Response
                .created(URI.create("/users/" + user.getUsername()))
                .build();
    }

    @DELETE
    @Path("/users/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("username") String username) {
        this.usersService.remove(username);
        return Response.ok().build();
    }
}
