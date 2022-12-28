package solid.o;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class OpenClosedMain {
    public static void main(String[] args) {
        UsersDBStatistics usersDBStatistics = new UsersDBStatistics();
        UsersExtra users = new UsersExtra(usersDBStatistics);

        User userA = new User();
        userA.setUsername("a");
        userA.setName("A");
        userA.setLastname("A A");
        userA.setEmail("a@com");
        userA.setAccessLevel(0);

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

        System.out.println(users.isAdmin(userA));
        System.out.println(users.isAdmin(userB));

        User existingUser = users.get("a");
        System.out.println(existingUser);
        System.out.println();

        users.remove(userB);

        users.getAll().forEach(System.out::println);

        System.out.println(usersDBStatistics.getInsertionsCount());
        System.out.println(usersDBStatistics.getDeletionsCount());

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
    private final UsersDB usersDB;
    public Users(UsersDB usersDB) {
        this.usersDB = usersDB;
    }
    public ArrayList<User> getAll() {
        return usersDB.getUsersFromFile();
    }
    public User get(String username) {
        ArrayList<User> usersList = usersDB.getUsersFromFile();
        return usersDB.getUser(usersList, username);
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

class UsersDB {
    private final String filePath;
    public UsersDB() {
        this.filePath = "src/resources/doc/users_db.dat";
    }
    public ArrayList<User> getUsersFromFile() {
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
    public void delete(User user) {
        ArrayList<User> usersList = getUsersFromFile();
        User userToDelete = getUser(usersList, user.getUsername());
        if (userToDelete != null) {
            usersList.remove(userToDelete);

            try (PrintStream printStream = new PrintStream(filePath)) {
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
    public User getUser(ArrayList<User> usersList , String username) {
        return usersList.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst().orElse(null);
    }
}
class UsersDBStatistics extends UsersDB {
    private int insertionsCount;
    private int deletionsCount;
    public UsersDBStatistics() {
        super();
    }

    @Override
    public void save(User user) {
        super.save(user);
        insertionsCount++;
    }

    public int getInsertionsCount() {
        return insertionsCount;
    }

    @Override
    public void delete(User user) {
        super.delete(user);
        deletionsCount++;
    }

    public int getDeletionsCount() {
        return deletionsCount;
    }
}
class UsersExtra extends Users {

    public UsersExtra(UsersDB usersDB) {
        super(usersDB);
    }
    public boolean isAdmin(User user) {
       return userByAccessLevel(user, 0);
    }
    public boolean isUser(User user) {
        return userByAccessLevel(user, 1);
    }
    private boolean userByAccessLevel (User user, int accessLevel) {
        if (get(user.getUsername()) == null) {
            return false;
        }
        return user.getAccessLevel() == accessLevel;
    }
}
