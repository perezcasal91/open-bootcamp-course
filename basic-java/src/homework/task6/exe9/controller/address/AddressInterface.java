package homework.task6.exe9.controller.address;

import java.util.Map;

public interface AddressInterface {
    Map<Integer, String> getCity();
    Map<Integer, String> getState();
    Map<Integer, String> getCountry();
    String getCity(Integer key);
    String getState(Integer key);
    String getCountry(Integer key);
}
