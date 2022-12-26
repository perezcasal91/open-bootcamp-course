package functions;

import java.util.ArrayList;
import java.util.Arrays;

public class FunctionMain {
    public static void main(String[] args) {
        functionsHandler();
        usersHandler();
    }
    private static void functionsHandler() {
        Functions cFunctions = new Functions();

        boolean bWeekday = cFunctions.isWeekday(4);
        System.out.println("Weekday: " + bWeekday);

        cFunctions.fruitDeterminate("peach");

        int[] aNumbers = {1, 2, 3, 4, 5};
        cFunctions.numberSum(aNumbers);

        cFunctions.infiniteSum(1, 2, 3, 4, 5);
    }
    private static void usersHandler() {
        Users cUsers = new Users();
        User cUser1 = new User();
        cUser1.setName("Elio");
        cUser1.setLast("Perez Casal");
        cUser1.setAge(31);
        cUser1.setCanDrive(false);
        User cUser2 = new User();
        cUser2.setName("Day");
        cUser2.setLast("Gonzalez Leon");
        cUser2.setAge(35);
        cUser2.setCanDrive(true);
        try {
            cUsers.addUsers(cUser1, cUser2);
            cUsers.addUsers(cUser1);
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
        cUsers.getAllUsers().forEach(System.out::println);
    }
}
class Functions {
    public boolean isWeekday(int day) {return (day > 1 && day < 6);}
    public void fruitDeterminate(String fruit) {
        switch (fruit) {
            case "apple", "pear", "peach", "banana"
                    -> System.out.println("The fruit is an: " + fruit);
            default -> System.out.println("The data you enter is not a fruit");
        }
    }
    public void numberSum(int []numbers) {
        var sum = Arrays.stream(numbers).reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
    }
    public void infiniteSum(int ...numbers) {
        var sum = Arrays.stream(numbers).reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
    }
}
/**
 * Class for handle the users
 * @since 12/20/22
 */
class Users {
    /**
     * List of users
     */
    private final ArrayList<User> alUsers;
    public Users() {this.alUsers = new ArrayList<>();}
    /**
     * Add user to the list
     * @param users One or more object of type user
     * @throws UserException If the user already exist in the list
     */
    public void addUsers(User ...users) throws UserException {
        for (User user : users) {
            if (alUsers.contains(user)) {
                throw new UserAddException(user.getName());
            }
            alUsers.add(user);
        }
    }
    /**
     * Get all the users of the list.
     * @return ArrayList of type user
     */
    public ArrayList<User> getAllUsers() {return alUsers;}
}
/**
 * Class User Model
 * @since 12/20/22
 */
class User {
    private String name;
    private String last;
    private int age;
    private boolean canDrive;
    public User() {}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getLast() {return last;}
    public void setLast(String last) {this.last = last;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    public boolean isCanDrive() {return canDrive;}
    public void setCanDrive(boolean canDrive) {this.canDrive = canDrive;}
    @Override
    public String toString() {
        return "User " +
                "{" +
                    " name=" + getName() +
                    ", last=" + getLast() +
                    ", age=" + getAge() +
                    ", canDrive=" + isCanDrive() +
                " } ";
    }
}
/**
 * Class for handle the user exceptions
 * @since 12/20/22
 */
class UserException extends Exception {
    public UserException (String message) {super("User Exception: " + message);}
}
/**
 * Class for handle the user add exception
 * @since 12/20/22
 */
class UserAddException extends UserException {
    public UserAddException (String message) {super("User Add Exception: User already exist: " + message);}
}
