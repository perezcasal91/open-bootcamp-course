package homework.task2.main;


import homework.task2.controllers.ArgumentsController;
import homework.task2.models.Rol;
import homework.task2.models.User;
import homework.task2.models.UserBuilder;
import homework.task2.services.option.OptionsService;
import homework.task2.services.user.UsersService;

public class Task19_20_21Main {
    public static void main(String[] args) {
        ArgumentsController argumentsController = new ArgumentsController(1);
        OptionsService optionsService = argumentsController.getOptionService();
        UsersService usersService = optionsService.getUserService(args);

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

        usersService.addUser(userE, userD, userC);
        usersService.addUser(userE, userD, userC, userA);
        usersService.deleteUser(userA);
        usersService.addUser(userE, userD, userC);
        usersService.getAllUsers().forEach(System.out::println);
        optionsService.printHelp();
    }
}

