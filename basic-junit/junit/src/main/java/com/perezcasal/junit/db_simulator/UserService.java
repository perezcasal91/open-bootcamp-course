package com.perezcasal.junit.db_simulator;

import java.util.ArrayList;

public class UserService {
    private final UserDB usersDB;

    public UserService(UserDB usersDB) {
        this.usersDB = usersDB;
    }

    public UserService(int dbType) {
        this.usersDB = UserDBFactory.getDatabaseInstance(dbType);
    }

    public ArrayList<User> getAll() {
        return usersDB.getAllUsers();
    }

    public User get(String username) {
        return usersDB.getUserByUsername(usersDB.getAllUsers(), username);
    }

    public boolean add(User user) {
        if (get(user.getUsername()) != null) {
            return false;
        }
        return usersDB.save(user);
    }

    public boolean remove(String username) {
        User user = get(username);
        if (user == null) {
            return false;
        }
        return usersDB.delete(user);
    }
}
