package homework.task6.exe9.controller.address;

import java.util.HashMap;
import java.util.Map;

public class AddressImplement implements AddressInterface{
    private Map<Integer, String> city;
    private Map<Integer, String> state;
    private Map<Integer, String> country;
    public AddressImplement(){
        fillCity();
        fillState();
        fillCountry();
    }
    private void fillCity(){
        this.city = new HashMap<>();
        this.city.put(1, "Jacksonville");
        this.city.put(2, "Miami");
        this.city.put(3, "Tampa");
        this.city.put(4, "Orlando");
        this.city.put(5, "Hialeah");
        this.city.put(6, "Fort Lauderdale");
        this.city.put(7, "West Palm Beach");
        this.city.put(8, "Clearwater");
        this.city.put(9, "Jupiter");
        this.city.put(10, "Fort Myers");
    }
    private void fillState(){
        this.state = new HashMap<>();
        this.state.put(1, "Alabama");
        this.state.put(2, "Georgia");
        this.state.put(3, "Virginia");
        this.state.put(4, "Washington");
        this.state.put(5, "Arizona");
        this.state.put(6, "Texas");
        this.state.put(7, "Florida");
        this.state.put(8, "Michigan");
        this.state.put(9, "Ohio");
        this.state.put(10, "New York");
    }
    private void fillCountry(){
        this.country = new HashMap<>();
        this.country.put(1, "Armenia");
        this.country.put(2, "Australia");
        this.country.put(3, "Belgium");
        this.country.put(4, "Brazil");
        this.country.put(5, "Canada");
        this.country.put(6, "China");
        this.country.put(7, "United States of America");
        this.country.put(8, "United Kingdom");
        this.country.put(9, "Italy");
        this.country.put(10, "Greece");
    }
    public Map<Integer, String> getCity() {
        return this.city;
    }
    public Map<Integer, String> getState() {
        return this.state;
    }
    public Map<Integer, String> getCountry() {
        return this.country;
    }
    public String getCity(Integer key) {
        return this.city.get(key);
    }
    public String getState(Integer key) {
        return this.state.get(key);
    }
    public String getCountry(Integer key) {
        return this.country.get(key);
    }
}
