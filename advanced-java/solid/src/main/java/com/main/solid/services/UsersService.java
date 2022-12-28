package com.main.solid.services;

import com.main.solid.entities.User;
import com.main.solid.repositories.FileUsersDB;
import com.main.solid.repositories.MemoryUsersDB;
import com.main.solid.repositories.UsersDB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsersService {
    private UsersDB usersDB;
    public UsersService() {}

    public void initDataBase(int dbType) {
        if (dbType == 1) {
            System.out.println("Using the File DataBase");
            this.usersDB = new FileUsersDB();
        } else {
            if (dbType == 2) {
                System.out.println("Using the Memory DataBase");
                this.usersDB = new MemoryUsersDB();
            }
        }
    }

    public ArrayList<User> getAll() {
        return usersDB.getAllUsers();
    }

    public User get(String username) {
        return usersDB.getUserByUsername(usersDB.getAllUsers(), username);
    }

    public void add(User user) {
        if (get(user.getUsername()) != null) {
            return;
        }
        usersDB.save(user);
    }

    public void remove(String username) {
        User user = get(username);
        if (user != null) {
            usersDB.delete(user);
        }
    }
}
