package solid.s;

public class UsersMain {
    public static void main(String[] args) {
        TestUsers users = new TestUsers();
        users.notifyAllUsers();
    }
}
class TestUsers {
    public void createUser() {}
    public void getUser() {}
    public void notifyAllUsers() {
        EmailHandler emailHandler = new EmailHandler();
        emailHandler.sendEmail(this);
    }
}
class EmailHandler {
    public void sendEmail(TestUsers users) {
        System.out.println("All the users has bean notifiers.");
    }
}