package homework.task2.services.parser;

 public interface OptionParserService {
    void insertOption(String key);
    void parse(String [] args);
    void setOption(String key, String value);
    String getOptionValue(String key);
    int getOptionIntValue(String key);
}
