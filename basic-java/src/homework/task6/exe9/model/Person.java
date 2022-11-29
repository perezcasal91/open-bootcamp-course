package homework.task6.exe9.model;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private String name;
    private Integer age;
    private Address address;
    private String [] phones;
    private Pattern pattern;
    public Person(){
        this.pattern = Pattern.compile("[A-Za-z]+([ '][A-Za-z]+)*");
    }
    public Person(String name, Integer age, Address address, String [] phones) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phones = phones;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) throws Exception{
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            this.name = name;
        } else {
            throw new Exception("The name that you just enter is not valid");
        }
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public String getPhones() {
        return Arrays.toString(this.phones);
    }
    public void setPhones(String [] phones) {
        this.phones = phones;
    }
    @Override
    public String toString() {
        return "Person {" +
                " name=" + this.getName() +
                ", age=" + this.getAge() +
                ", address=" + this.getAddress() +
                ", phones=" + this.getPhones() +
                " } ";
    }
}
