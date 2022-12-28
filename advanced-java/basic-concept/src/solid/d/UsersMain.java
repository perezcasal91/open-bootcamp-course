package solid.d;

public class UsersMain {
    public static void main(String[] args) {
        User userA = new User();
        userA.setUsername("a");
        userA.setName("A");

        Users users = new Users(1);
        users.save(userA);
        System.out.println();

        User userB = new User();
        userB.setUsername("b");
        userB.setName("B");

        users = new Users(2);
        users.save(userB);
    }
}
class Users {
    private DataBaseStorage dataBaseStorage;
    public Users(int dbType) {
        if (dbType == 1) {
            this.dataBaseStorage = new DataBaseMySQL();
        } else {
            if (dbType == 2) {
                this.dataBaseStorage = new DataBaseSQLite();
            }
        }
    }
    public void save(User user) {
        dataBaseStorage.saveUser(user);
    }
}
class User {
    private String username;
    private String name;
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
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
interface DataBaseStorage {
    void saveUser(User user);
}
class DataBaseMySQL implements DataBaseStorage {
    public DataBaseMySQL() {}
    @Override
    public void saveUser(User user) {
        System.out.println("DataBaseMySql: user " + user.getName() + " saved.");
    }
}
class DataBaseSQLite implements DataBaseStorage {
    public DataBaseSQLite() {}
    @Override
    public void saveUser(User user) {
        System.out.println("DataBaseSQLite: user " + user.getName() + " saved.");
    }
}