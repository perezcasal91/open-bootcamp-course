package homework.task6.exe9.controller.address;

import java.util.Map;

public interface AddressInterface {
    Map<Integer, String> getCities();
    Map<Integer, String> getStates();
    Map<Integer, String> getCountries();
    String getCity(Integer key);
    String getState(Integer key);
    String getCountry(Integer key);
}
