package homework.task2.controllers.arguments;


import homework.task2.services.option.ApacheCLIOptionsImplement;
import homework.task2.services.option.OptionsService;
import homework.task2.services.option.PersonalOptionsImplement;
import homework.task2.services.user.UsersService;

public class ArgumentsController {
    private final int service;
    private OptionsService optionsService;
    public ArgumentsController(int service) {
        this.service = service;
        getOptionService();
    }

    private void getOptionService() {
        if (service == 0) {
            optionsService = new PersonalOptionsImplement();
        }else {
            optionsService = new ApacheCLIOptionsImplement();
        }
    }
    public UsersService getUserService(String [] args) {
        return optionsService.getUserService(args);
    }
    public void printHelp() {
        optionsService.printHelp();
    }
}
