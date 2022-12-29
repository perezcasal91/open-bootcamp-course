package com.main.solid.repositories;

import com.main.solid.entities.User;

import java.util.ArrayList;

public class UsersDBNullable implements UsersDB {
    @Override
    public ArrayList<User> getAllUsers() { return null; }
    @Override
    public void save(User user) {}
    @Override
    public void delete(User user) {}
    @Override
    public User getUserByUsername(ArrayList<User> usersList, String username) { return null; }
}
