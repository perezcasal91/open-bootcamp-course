package concepts;


import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.util.ArrayList;

public class ReadWriteJSON {
    private final JSONObject jsonObject;
    public ReadWriteJSON(){
        try {
            File inputFile = new File("src/resources/json/json_file.json");
            InputStream inputStream = new FileInputStream(inputFile);
            JSONTokener jsonTokener = new JSONTokener(inputStream);
            this.jsonObject = new JSONObject(jsonTokener);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void read(){
        readObject(this.jsonObject);
    }
    private void readObject(Object object){
        String className = object.getClass().getSimpleName();
        switch (className) {
            case "JSONObject" -> ((JSONObject) object).keySet().forEach((key)->
            {System.out.println(key);readObject(((JSONObject) object).get(key));});
            case "JSONArray" -> ((JSONArray) object).forEach(this::readObject);
            case "String", "Float", "Integer", "Double", "Number", "Long",
                    "BigInteger", "BigDecimal" -> System.out.println(object);
        }
    }
    public void readByKey(){
        ArrayList<Person> personArrayList = new ArrayList<>();
        JSONObject personJsonObject = (JSONObject) this.jsonObject.get("person1");
        Person person = new Person();
        person.setFirstName((String) personJsonObject.get("firstName"));
        person.setLastName((String) personJsonObject.get("lastName"));
        person.setAge((Integer) personJsonObject.get("age"));
        personArrayList.add(person);
        personJsonObject = (JSONObject) this.jsonObject.get("person2");
        person = new Person();
        person.setFirstName((String) personJsonObject.get("firstName"));
        person.setLastName((String) personJsonObject.get("lastName"));
        person.setAge((Integer) personJsonObject.get("age"));
        personArrayList.add(person);
        JSONArray personJsonArray = (JSONArray) this.jsonObject.get("phoneNumbers");
        int index = 0;
        for (Object row: personJsonArray) {
            Phone phone = new Phone();
            phone.setType(((JSONObject)row).getString("type"));
            phone.setPhoneNumber(((JSONObject)row).getString("phone-number"));
            personArrayList.get(index).setPhone(phone);
            index++;
        }
        personArrayList.forEach(System.out::println);
    }
    public void createJSON(){
        Person person = new Person();
        person.setFirstName("Elio");
        person.setLastName("Perez");
        person.setAge(31);
        Phone phone = new Phone();
        phone.setType("Mobile");
        phone.setPhoneNumber("561-534-5678");
        person.setPhone(phone);
        JSONObject valuesJsonObject = new JSONObject();
        valuesJsonObject.put("first-name", person.getFirstName());
        valuesJsonObject.put("last-name", person.getLastName());
        valuesJsonObject.put("age", person.getAge());
        JSONObject personJsonObject = new JSONObject();
        personJsonObject.put("person", valuesJsonObject);
        try {
            File outputFile = new File("src/resources/json/json_output_file.json");
            FileWriter fileWriter = new FileWriter(outputFile);
            fileWriter.write(personJsonObject.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Phone phone;
    public Person() {
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Phone getPhone() {
        return this.phone;
    }
    public void setPhone(Phone phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "Person {" +
                " firstName=" + this.getFirstName() +
                ", lastName=" + this.getLastName() +
                ", age=" + this.getAge() +
                ", phone=" + this.getPhone() +
                " } ";
    }
}
class Phone {
    private String type;
    private String phoneNumber;
    public Phone() {}
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return "[" +
                " type=" + this.getType() +
                ", phoneNumber=" + this.getPhoneNumber() +
                " ]";
    }
}
