package homework.task2.services.option;


import homework.task2.services.parser.OptionParserImplement;
import homework.task2.services.parser.OptionParserService;
import homework.task2.services.user.FileUsersImplement;
import homework.task2.services.user.MemoryUsersImplement;
import homework.task2.services.user.UsersService;

import java.io.PrintWriter;

public class PersonalOptionsImplement implements OptionsService {
    private final OptionParserService optionParserService;
    public PersonalOptionsImplement() {
        this.optionParserService = new OptionParserImplement();
    }
    @Override
    public UsersService getUserService(String [] args) {
        optionParserService.insertOption("usercontroller");
        optionParserService.parse(args);
        int service = optionParserService.getOptionIntValue("usercontroller");
        if (service == 0) {
            return new FileUsersImplement();
        }
        return new MemoryUsersImplement();
    }
    @Override
    public void printHelp() {
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println("Task 2");
        printWriter.println();
        String cmdLineSyntax = "java -jar Task2.jar [options] usercontroller";
        System.out.println(cmdLineSyntax);
        printWriter.close();
    }
}
