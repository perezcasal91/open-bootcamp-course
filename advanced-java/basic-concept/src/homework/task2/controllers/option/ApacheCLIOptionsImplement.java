package homework.task2.controllers.option;


import homework.task2.services.user.FileUsersImplement;
import homework.task2.services.user.MemoryUsersImplement;
import homework.task2.services.user.UsersService;
import org.apache.commons.cli.*;

import java.io.PrintWriter;

public class ApacheCLIOptionsImplement implements OptionsController {
    private Options options;
    private Option userController;

    public ApacheCLIOptionsImplement() {
        initOptions();
    }

    private void initOptions() {
        userController = new Option("u", "usercontroller", true, "User Controller");
        options = new Options();
        options.addOption(userController);
    }
    @Override
    public UsersService getUserService(String [] args) {
        int service = -1;
        try {
            CommandLineParser commandLineParser = new BasicParser();
            CommandLine commandLine = commandLineParser.parse(options, args);

            if (commandLine.hasOption(userController.getOpt())) {
                service = Integer.parseInt(commandLine.getOptionValue(userController.getOpt()));
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        if (service == 0) {
            return new FileUsersImplement();
        }
        return new MemoryUsersImplement();
    }
    @Override
    public void printHelp() {
        HelpFormatter helpFormatter = new HelpFormatter();
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println("Task 2");
        printWriter.println();
        String cmdLineSyntax = "java -jar Task2.jar [options] usercontroller";
        helpFormatter.printUsage(printWriter, 100, cmdLineSyntax);
        helpFormatter.printOptions(printWriter, 100, options, 2, 5);
        printWriter.close();
    }
}
