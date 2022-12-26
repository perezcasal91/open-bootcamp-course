package homework.task2.services.user;

import homework.task2.models.Rol;
import homework.task2.models.User;
import homework.task2.models.UserBuilder;
import homework.task2.services.file.FileImplement;
import homework.task2.services.file.FileService;

import java.util.ArrayList;

public class FileUsersImplement implements UsersService {
        private final FileService fileService;
        private ArrayList<User> usersList;
        public FileUsersImplement() {
            this.fileService = new FileImplement();
            getUsersFromFile();
        }
        private void getUsersFromFile() {
            initUsersList();
            ArrayList<String> stringLineList = fileService.readFile();
            for (String line : stringLineList) {
                var values = replace(line);

                User user = new UserBuilder()
                        .setUsername(values[1])
                        .setName(values[2])
                        .setLastname(values[3])
                        .setEmail(values[4])
                        .setRol(Rol.valueOf(values[5].replace(" ", "")))
                        .build();

                usersList.add(user);
            }
        }
        private void initUsersList() {
            this.usersList = new ArrayList<>();
        }
        @Override
        public ArrayList<User> getAllUsers() {
            getUsersFromFile();
            return usersList;
        }
        private String[] replace(String line) {
            return line.substring(16, line.length() - 2)
                    .replace(",", "")
                    .replace(" name", "")
                    .replace(" lastname", "")
                    .replace(" email", "")
                    .replace(" rol", "")
                    .split("=");
        }
        @Override
        public void addUser(User ...users) {
            getUsersFromFile();
            for (User user: users) {
                if (usersList.stream().noneMatch(u -> u.getUsername().equals(user.getUsername()))) {
                    fileService.addLine(user.toString());
                } else {
                    System.out.println("The user already exist.");
                }
            }
            initUsersList();
        }
        @Override
        public void deleteUser(User ...users) {
            getUsersFromFile();
            for (User user: users) {
                var userToDelete = getUser(user);
                if (userToDelete != null) {
                    this.usersList.remove(userToDelete);
                }
            }
            fileService.deleteLine(usersList.stream().map(User::toString).toList());
            initUsersList();
        }
    public User getUser(User user) {
        getUsersFromFile();
        return usersList.stream()
                .filter(u -> u.getUsername().equals(user.getUsername()))
                .findFirst()
                .orElse(null);
    }
        @Override
        public User getUser(String username) {
            getUsersFromFile();
            return usersList.stream()
                    .filter(user -> user.getUsername().equals(username))
                    .findFirst()
                    .orElse(null);
        }
}
