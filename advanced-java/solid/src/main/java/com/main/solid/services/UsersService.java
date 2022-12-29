package com.main.solid.services;

import com.main.solid.entities.User;
import com.main.solid.entities.UserBuilder;
import com.main.solid.repositories.UsersDB;
import com.main.solid.repositories.UsersDBFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsersService {
    private final UsersDB usersDB;
    public UsersService() {
        this.usersDB = UsersDBFactory.getDatabaseInstance(2);
    }
    public ArrayList<User> getAll() {
        return usersDB.getAllUsers();
    }
    public User get(String username) {
        return usersDB.getUserByUsername(usersDB.getAllUsers(), username);
    }
    public void add(User user) {
        if (get(user.getUsername()) != null) {
            return;
        }
        usersDB.save(createUser(user));
    }
    public User createUser(User user) {
        return new UserBuilder()
                .setUsername(user.getUsername())
                .setName(user.getName())
                .setLastname(user.getLastname())
                .setEmail(user.getEmail())
                .setAccessLevel(user.getAccessLevel())
                .build();
    }
    public void remove(String username) {
        User user = get(username);
        if (user != null) {
            usersDB.delete(user);
        }
    }
}
