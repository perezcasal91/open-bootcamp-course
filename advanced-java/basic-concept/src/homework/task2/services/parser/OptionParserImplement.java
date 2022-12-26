package homework.task2.services.parser;

import java.util.HashMap;

public class OptionParserImplement implements OptionParserService {
    private final HashMap<String, String> options;

    public OptionParserImplement() {
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
    @Override
    public void setOption(String key, String value) {
        options.replace(key.toLowerCase(), value);
    }
    @Override
    public String getOptionValue(String key) {
        return options.get(key.toLowerCase());
    }
    @Override
    public int getOptionIntValue(String key) {
        return Integer.parseInt(getOptionValue(key));
    }
}
