package com.perezcasal.junit.db_simulator;

import java.util.ArrayList;

public class MemoryUserDB implements UserDB {
    private final ArrayList<User> usersList;

    public MemoryUserDB() {
        this.usersList = new ArrayList<>();
    }
    @Override
    public ArrayList<User> getAllUsers() {
        return usersList;
    }

    @Override
    public boolean save(User user) {
        return usersList.add(user);
    }
    @Override
    public boolean delete(User user) {
        return usersList.remove(user);
    }
    @Override
    public User getUserByUsername(ArrayList<User> usersList , String username) {
        return usersList.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst().orElse(null);
    }

}
