package com.perezcasal.junit.db_simulator;

import java.util.ArrayList;

public class NullableUserDB implements UserDB {
    @Override
    public ArrayList<User> getAllUsers() {
        return null;
    }

    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public User getUserByUsername(ArrayList<User> usersList, String username) {
        return null;
    }

}
