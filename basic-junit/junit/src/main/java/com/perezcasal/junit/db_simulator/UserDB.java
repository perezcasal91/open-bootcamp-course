package com.perezcasal.junit.db_simulator;

import java.util.ArrayList;

public interface UserDB {
    ArrayList<User> getAllUsers();
    boolean save(User user);
    boolean delete(User user);
    User getUserByUsername(ArrayList<User> usersList , String username);
}
