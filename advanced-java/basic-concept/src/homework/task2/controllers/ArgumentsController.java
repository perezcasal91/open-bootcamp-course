package homework.task2.controllers;


import homework.task2.services.option.ApacheCLIOptionsImplement;
import homework.task2.services.option.OptionsService;
import homework.task2.services.option.PersonalOptionsImplement;

public class ArgumentsController {
    private final int service;

    public ArgumentsController(int service) {
        this.service = service;
    }

    public OptionsService getOptionService() {
        if (service == 0) {
            return new PersonalOptionsImplement();
        }
        return new ApacheCLIOptionsImplement();
    }
}
