package com.main.solid.repositories;

import com.main.solid.entities.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUsersDB extends UsersDB {
    private final String filePath;
    public FileUsersDB() {
        this.filePath = "src/resources/doc/users_db.dat";
    }
    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> usersList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                String [] values = stringUserToStringArray(scanner.nextLine());

                User user = new User();
                user.setUsername(values[0]);
                user.setName(values[1]);
                user.setLastname(values[2]);
                user.setEmail(values[3]);
                user.setAccessLevel(Integer.parseInt(values[4]));

                usersList.add(user);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("There was an error reading the file: " + e.getMessage());
        }
        return usersList;
    }

    private String[] stringUserToStringArray(String stringUser) {
        return stringUser
                .replace("User{ username:", "")
                .replace("name:", "")
                .replace("last", "")
                .replace("email:", "")
                .replace("access-level:", "")
                .replace(" }", "")
                .split(",");
    }
    @Override
    public void save(User user) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.println(user);
            printStream.flush();
            printStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("There was an error to saving the user: " + e.getMessage());
        }
    }
    @Override
    public void delete(User user) {
        ArrayList<User> usersList = getAllUsers();
        User userToDelete = getUserByUsername(usersList, user.getUsername());
        if (userToDelete != null) {
            usersList.remove(userToDelete);

            try (PrintStream printStream = new PrintStream(filePath)){
                for (User existingUser : usersList) {
                    printStream.println(existingUser);
                }
                printStream.flush();
            } catch (FileNotFoundException e) {
                System.out.println("There was an error deleting the user: " + e.getMessage());
            }
        } else {
            System.out.println("There was an error deleting the user: " + user.getUsername() + "not found.");
        }
    }
    @Override
    public User getUserByUsername(ArrayList<User> usersList , String username) {
        return usersList.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst().orElse(null);
    }
}
