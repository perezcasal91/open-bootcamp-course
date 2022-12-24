package arguments;

import org.apache.commons.cli.*;
import java.io.PrintWriter;

class ApacheCLIMain {
    public static void main(String[] args) {
        Options options = new Options();

        Option minOption = new Option("min", "minvalue", true, "Min Value");
        Option maxOption = new Option("max", "maxvalue", true, "Max Value");
        Option nameOption = new Option("nm", "name", true, "Name Value");

        options.addOption(minOption);
        options.addOption(maxOption);
        options.addOption(nameOption);

        CommandLineParser commandLineParser = new BasicParser();

        try {
            CommandLine commandLine = commandLineParser.parse(options, args);
           if (commandLine.hasOption(minOption.getOpt())) {
               System.out.println("Min Value: " + commandLine.getOptionValue(minOption.getOpt()));
           }
           if (commandLine.hasOption(maxOption.getOpt())) {
               System.out.println("Min Value: " + commandLine.getOptionValue(maxOption.getOpt()));
           }
           if (commandLine.hasOption(nameOption.getOpt())) {
                System.out.println("Min Value: " + commandLine.getOptionValue(nameOption.getOpt()));
            }
            System.out.println();
            printHelp(options);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    private static void printHelp(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println("Apache CLI App");
        printWriter.println();
        String cmdLineSyntax = "java -jar ApacheCLIMain.jar [options] minvalue maxvalue name";
        helpFormatter.printUsage(printWriter, 100, cmdLineSyntax);
        helpFormatter.printOptions(printWriter, 100, options, 2, 5);
        printWriter.close();
    }
}
