package named;

import javax.swing.*;

public class NamingMain {
}
// Class Name : Camel Case
class ReverseString {}
class UserManager {
    // Static or Constant Variable Name: All in Upper Case
    // if their more than one word, we separated with Underscore
    private static final int MAX_USERS = 15;
    // Name of the variable has to have meaning
    private int count;
    // We can use a suffix for the name considering the initial of the data type
    // we put the initials in Lower Case
    private JButton jbOk;
    // Method Name : Camel Case
    private void createUser() {
        // If the value is more than one, is better if we use the name in plural
        int [] aiNumbers = {1,2,3,4,5};
        // The conventional name for the variable inside the loop for are: i, j, k, and successively;
        for (int i = 0; i < aiNumbers.length; i++) {
            System.out.println(i);
        }
    }
}
// Interface Class Name: Camel Case, try to finished in (able)
// and always as possible use an adjective
interface Iterable {}
interface Serializable {}
interface UserIterable {}
