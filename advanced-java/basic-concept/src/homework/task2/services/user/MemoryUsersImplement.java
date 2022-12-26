package homework.task2.services.user;

import homework.task2.domain.MemoryData;
import homework.task2.models.User;

import java.util.List;

public class MemoryUsersImplement implements UsersService {
    private final MemoryData memoryData;
    public MemoryUsersImplement() {
        this.memoryData = MemoryData.getInstance();
    }
    @Override
    public List<User> getAllUsers() {
        return  memoryData.getAll().
                stream().
                map(o -> (User)o).
                toList();
    }
    @Override
    public void addUsers(User ...users) {
        for (User user : users ) {
            if (!memoryData.contains(user)) {
                memoryData.save(user);
            } else {
                System.out.println("The user already exist.");
            }
        }
    }
    @Override
    public void deleteUsers(User ...users) {
        for (User user : users ) {
            memoryData.delete(user);
        }
    }
    @Override
    public User getUser(String username) {
        return getAllUsers().stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}
