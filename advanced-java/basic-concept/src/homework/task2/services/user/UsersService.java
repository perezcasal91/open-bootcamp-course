package homework.task2.services.user;

import homework.task2.models.User;

import java.util.List;

public interface UsersService {

    List<User> getAllUsers();

    void addUser(User ...users);

    void deleteUser(User ...users);

    User getUser(String username);
}
