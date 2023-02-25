package com.perezcasal.junit.db_simulator;


public class UserDBFactory {
    public static UserDB getDatabaseInstance(int dbType) {
        if (dbType == 1) {
            System.out.println("Using the File DataBase");
            return new FileUserDB();
        }
        if (dbType == 2) {
            System.out.println("Using the Memory DataBase");
            return new MemoryUserDB();
        }

        return new UserDBStub();
    }
}
