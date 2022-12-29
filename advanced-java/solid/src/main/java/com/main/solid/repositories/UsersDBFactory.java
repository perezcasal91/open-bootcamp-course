package com.main.solid.repositories;

public class UsersDBFactory {
    public static UsersDB getDatabaseInstance(int dbType) {
        if (dbType == 1) {
            System.out.println("Using the File DataBase");
            return new FileUsersDB();
        } else {
            if (dbType == 2) {
                System.out.println("Using the Memory DataBase");
                return new MemoryUsersDB();
            }
        }
        return new UsersDBNullable();
    }
}
