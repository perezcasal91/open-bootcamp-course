package homework.task2.services.option;


import homework.task2.services.user.UsersService;

public interface OptionsService {
    UsersService getUserService(String [] args);
    void printHelp();
}
