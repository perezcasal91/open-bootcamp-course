package homework.task2.controllers.user;

import homework.task2.models.User;
import homework.task2.services.user.UsersService;

import java.util.List;

public class UsersController {
    UsersService usersService;
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
    public List<User> getAllUsers() {
        return usersService.getAllUsers();
    }

    public void addUser(User ...users) {
        usersService.addUsers(users);
    }

    public void deleteUser(User ...users) {
        usersService.deleteUsers(users);
    }

    public User getUser(String username) {
        return usersService.getUser(username);
    }
}
