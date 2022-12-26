package homework.task2.controllers.option;


import homework.task2.services.user.UsersService;

public interface OptionsController {
    UsersService getUserService(String [] args);
    void printHelp();
}
