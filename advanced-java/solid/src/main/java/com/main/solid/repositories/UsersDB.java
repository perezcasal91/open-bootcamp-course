package com.main.solid.repositories;

import com.main.solid.entities.User;
import java.util.ArrayList;

public abstract class UsersDB {
    public abstract ArrayList<User> getAllUsers();
    public abstract void save(User user);
    public abstract void delete(User user);
    public abstract User getUserByUsername(ArrayList<User> usersList , String username);
}
