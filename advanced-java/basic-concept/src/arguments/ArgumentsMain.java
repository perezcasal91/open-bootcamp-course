package arguments;

import java.util.HashMap;

public class ArgumentsMain {
    public static void main(String[] args) {
        OptionsParser optionsParser = new OptionsParser();
        
        optionsParser.insertOption("minValue");
        optionsParser.insertOption("maxValue");
        optionsParser.insertOption("name");

        optionsParser.parse(args);

        System.out.println(optionsParser.getOptionIntValue("minvalue"));
        System.out.println(optionsParser.getOptionIntValue("maxvalue"));
        System.out.println(optionsParser.getOptionValue("name"));

    }
}
class OptionsParser {
    private final HashMap<String, String> options;
    public OptionsParser () {
        this.options = new HashMap<>();
    }
    public void insertOption(String key) {
        options.put(key.toLowerCase(), "");
    }
    public void parse(String [] args) {
        for (int i = 0; i < args.length; i++) {

            String key = args[i].replace("-", "").toLowerCase();

            if (options.containsKey(key)) {
                setOption(key, args[i + 1]);
                i++;
            }
        }
    }
    private void setOption(String key, String value) {
        options.replace(key.toLowerCase(), value);
    }
    public int getOptionIntValue(String key) {
       return Integer.parseInt(getOptionValue(key));
    }
    public String getOptionValue(String key) {
        return options.get(key.toLowerCase());
    }
}