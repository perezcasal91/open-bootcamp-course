package com.perezcasal.junit.management.database;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    private final List<Object> objectsDB;
    private static UserDB userDB;
    private UserDB() {
        objectsDB = new ArrayList<>();
    }
    public static UserDB openConnection() {
        if (userDB == null) {
            userDB = new UserDB();
        }
        return userDB;
    }
    public static void closeConnection() {
        userDB = null;
    }
    public boolean save(Object o) {
        return objectsDB.add(o);
    }
    public List<Object> findAll() {
        return objectsDB;
    }
    public Object update(int index, Object o) {
        return objectsDB.set(index, o);
    }
    public boolean delete(Object o) {
        return objectsDB.remove(o);
    }
}
