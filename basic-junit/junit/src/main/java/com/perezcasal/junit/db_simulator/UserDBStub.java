package com.perezcasal.junit.db_simulator;

import java.util.ArrayList;

public class UserDBStub implements UserDB {
    User user;

    public UserDBStub() {
        init();
    }

    private void init() {
        user = new User.Builder()
                .setName("Elio")
                .setLastname("Perez")
                .setUsername("elio")
                .setEmail("elio@gmail.com")
                .setAccessLevel(1)
                .build();
    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();

        users.add(user);

        return users;
    }

    @Override
    public boolean save(User user) {
        return true;
    }

    @Override
    public boolean delete(User user) {
        return true;
    }

    @Override
    public User getUserByUsername(ArrayList<User> usersList, String username) {
        return user;
    }
}
