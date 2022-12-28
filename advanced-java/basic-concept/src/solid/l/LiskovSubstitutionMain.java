package solid.l;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class LiskovSubstitutionMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the DataBase to use:");
        System.out.println("1 - File DataBase | 2 - Memory DataBase");
        int dbType = scanner.nextInt();
        Users users = new Users(dbType);

        User userA = new User();
        userA.setUsername("a");
        userA.setName("A");
        userA.setLastname("A A");
        userA.setEmail("a@com");
        userA.setAccessLevel(1);

        users.add(userA);

        User userB = new User();
        userB.setUsername("b");
        userB.setName("B");
        userB.setLastname("B B");
        userB.setEmail("b@com");
        userB.setAccessLevel(1);

        users.add(userB);

        User userC = new User();
        userC.setUsername("c");
        userC.setName("C");
        userC.setLastname("C C");
        userC.setEmail("c@com");
        userC.setAccessLevel(1);

        users.add(userC);

        User existingUser = users.get("a");
        System.out.println(existingUser);
        System.out.println();

        users.remove(userB);

        users.getAll().forEach(System.out::println);

    }
}
class User {
    private String username;
    private String name;
    private String lastname;
    private String email;
    private int accessLevel;

    public User() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public String toString() {
        return "User{ "
                + "username:" + getUsername()
                + ",name:" + getName()
                + ",lastname:" + getLastname()
                + ",email:" + getEmail()
                + ",access-level:" + getAccessLevel()
                + " }";
    }
}
class Users {
    private UsersDB usersDB;
    public Users(int dbType) {
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

    public void remove(User user) {
        usersDB.delete(user);
    }
}
abstract class UsersDB {
    abstract ArrayList<User> getAllUsers();
    abstract void save(User user);
    abstract void delete(User user);
    abstract User getUserByUsername(ArrayList<User> usersList , String username);
}
class FileUsersDB extends UsersDB {
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
class MemoryUsersDB extends UsersDB {
    private final ArrayList<User> usersList;
    public MemoryUsersDB() {
        this.usersList = new ArrayList<>();
    }
    @Override
    public ArrayList<User> getAllUsers() {
        return usersList;
    }

    @Override
    public void save(User user) {
        if (getUserByUsername(usersList,  user.getUsername()) != null) {
            return;
        }
        usersList.add(user);
    }
    @Override
    public void delete(User user) {
        usersList.remove(user);
    }
    @Override
    public User getUserByUsername(ArrayList<User> usersList , String username) {
        return usersList.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst().orElse(null);
    }
}
