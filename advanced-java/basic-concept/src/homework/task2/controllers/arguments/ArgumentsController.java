package homework.task2.controllers.arguments;


import homework.task2.controllers.option.ApacheCLIOptionsImplement;
import homework.task2.controllers.option.OptionsController;
import homework.task2.controllers.option.PersonalOptionsImplement;

public class ArgumentsController {
    private final int controller;

    public ArgumentsController(int controller) {
        this.controller = controller;
    }

    public OptionsController getOptionService() {
        if (controller == 0) {
            return new PersonalOptionsImplement();
        }
        return new ApacheCLIOptionsImplement();
    }
}
