package homework.task6.exe9.controller.address;

import java.util.HashMap;
import java.util.Map;

public class AddressImplement implements AddressInterface {
    private Map<Integer, String> cities;
    private Map<Integer, String> states;
    private Map<Integer, String> countries;
    public AddressImplement() {
        fillCity();
        fillState();
        fillCountry();
    }
    private void fillCity() {
        this.cities = new HashMap<>();
        this.cities.put(1, "Jacksonville");
        this.cities.put(2, "Miami");
        this.cities.put(3, "Tampa");
        this.cities.put(4, "Orlando");
        this.cities.put(5, "Hialeah");
        this.cities.put(6, "Fort Lauderdale");
        this.cities.put(7, "West Palm Beach");
        this.cities.put(8, "Clearwater");
        this.cities.put(9, "Jupiter");
        this.cities.put(10, "Fort Myers");
    }
    private void fillState() {
        this.states = new HashMap<>();
        this.states.put(1, "Alabama");
        this.states.put(2, "Georgia");
        this.states.put(3, "Virginia");
        this.states.put(4, "Washington");
        this.states.put(5, "Arizona");
        this.states.put(6, "Texas");
        this.states.put(7, "Florida");
        this.states.put(8, "Michigan");
        this.states.put(9, "Ohio");
        this.states.put(10, "New York");
    }
    private void fillCountry() {
        this.countries = new HashMap<>();
        this.countries.put(1, "Armenia");
        this.countries.put(2, "Australia");
        this.countries.put(3, "Belgium");
        this.countries.put(4, "Brazil");
        this.countries.put(5, "Canada");
        this.countries.put(6, "China");
        this.countries.put(7, "United States of America");
        this.countries.put(8, "United Kingdom");
        this.countries.put(9, "Italy");
        this.countries.put(10, "Greece");
    }
    public Map<Integer, String> getCities() {
        return this.cities;
    }
    public Map<Integer, String> getStates() {
        return this.states;
    }
    public Map<Integer, String> getCountries() {
        return this.countries;
    }
    public String getCity(Integer key) {
        return this.cities.get(key);
    }
    public String getState(Integer key) {
        return this.states.get(key);
    }
    public String getCountry(Integer key) {
        return this.countries.get(key);
    }
}
