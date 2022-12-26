package homework.task2.main;


import homework.task2.controllers.arguments.ArgumentsController;
import homework.task2.controllers.user.UsersController;
import homework.task2.models.Rol;
import homework.task2.models.User;
import homework.task2.models.UserBuilder;
import homework.task2.services.option.OptionsService;

public class Task19_20_21Main {
    public static void main(String[] args) {
        ArgumentsController argumentsController = new ArgumentsController(1);
        UsersController usersController = new UsersController(argumentsController.getUserService(args));

        User userE = new UserBuilder()
                .setUsername("perezcasal91")
                .setName("Elio")
                .setLastname("Perez Casal")
                .setEmail("perezcasal91@gmail.com")
                .setRol(Rol.ADMIN)
                .build();

        User userD = new UserBuilder()
                .setUsername("daylenleon87")
                .setName("Daylen")
                .setLastname("Gonzalez Leon")
                .setEmail("daylenleon87@gmail.com")
                .setRol(Rol.USER)
                .build();

        User userC = new UserBuilder()
                .setUsername("calos91")
                .setName("Carlos")
                .setLastname("Perez Leon")
                .setEmail("carlos91@gmail.com")
                .setRol(Rol.USER)
                .build();

        User userA = new UserBuilder()
                .setUsername("noel69")
                .setName("Noel")
                .setLastname("Perez Sanchez")
                .setEmail("noel69@gmail.com")
                .setRol(Rol.USER)
                .build();

        usersController.addUser(userE, userD, userC);
        usersController.addUser(userE, userD, userC, userA);
        usersController.deleteUser(userA);
        usersController.addUser(userE, userD, userC);
        usersController.getAllUsers().forEach(System.out::println);
        argumentsController.printHelp();
    }
}

