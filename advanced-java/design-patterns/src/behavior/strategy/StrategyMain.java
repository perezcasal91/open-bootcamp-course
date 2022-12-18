package behavior.strategy;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

public class StrategyMain {
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        Users memoryUsers = new MemoryUsers();
        userManagement.addUser(memoryUsers, new User("a"));
        userManagement.addUser(memoryUsers, new User("b"));
        userManagement.addUser(memoryUsers, new User("c"));
        UsersFile usersFile = new UsersFile();
        userManagement.addUser(usersFile, new User("a"));
        userManagement.addUser(usersFile, new User("b"));
        userManagement.addUser(usersFile, new User("c"));
        userManagement.showUsers(memoryUsers);
        System.out.println();
        userManagement.showUsers(usersFile);
    }
}
class UserManagement {
    public void addUser(Users users, User user){users.addUser(user);}
    public ArrayList<User> getUsers(Users users) {return users.getUsers();}
    public void showUsers(Users users){getUsers(users).forEach(user -> System.out.println(user.name()));}
}
record User(String name) {}
interface Users {
    void addUser(User user);
    ArrayList<User> getUsers();
}
class MemoryUsers implements Users{
    private final ArrayList<User> users;
    public MemoryUsers() {
        this.users = new ArrayList<>();
    }
    @Override
    public void addUser(User user){
        this.users.add(user);
    }
    @Override
    public ArrayList<User> getUsers(){
        return users;
    }
}
class UsersFile implements Users{
    private final File file;
    private final PrintWriter printWriter;
    private final ArrayList<User> users;
    public UsersFile() {
        try {
            String path = "src/resources/doc/users_file.txt";
            this.file = new File(path);
            this.printWriter = new PrintWriter(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.users = new ArrayList<>();
    }
    @Override
    public void addUser(User user){
        printWriter.println(user.name());
        printWriter.flush();
    }
    @Override
    public ArrayList<User> getUsers() {
        try (var nameList = Files.lines(file.toPath(), StandardCharsets.UTF_8)){
            nameList.forEach(name-> users.add(new User(name)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
