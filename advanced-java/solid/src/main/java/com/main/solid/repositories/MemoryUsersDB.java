package com.main.solid.repositories;

import com.main.solid.entities.User;

import java.util.ArrayList;

public class MemoryUsersDB extends UsersDB {
    private final ArrayList<User> usersList;
    public MemoryUsersDB() {
        this.usersList = new ArrayList<>();
    }
    @Override
    public ArrayList<User> getAllUsers() {
        return usersList;
    }

    @Override
    public void save(User user) {
        if (getUserByUsername(usersList,  user.getUsername()) != null) {
            return;
        }
        usersList.add(user);
    }
    @Override
    public void delete(User user) {
        usersList.remove(user);
    }
    @Override
    public User getUserByUsername(ArrayList<User> usersList , String username) {
        return usersList.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst().orElse(null);
    }
}
