package concepts;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.*;
import java.util.ArrayList;

/**
 * Class with an example of read and write an JSON.
 */
public class ReadWriteJSON {
    private final JSONObject jsonObject;
    public ReadWriteJSON(){
        try {
            File fInput = new File("src/resources/json/json_file.json");
            InputStream isInput = new FileInputStream(fInput);
            JSONTokener jtJSON = new JSONTokener(isInput);
            this.jsonObject = new JSONObject(jtJSON);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Method Read with a recursive method inside.
     */
    public void read(){
        readObject(this.jsonObject);
    }

    /**
     * Recursive Read the Object inside the JSON by type.
     * @param object Value
     */
    private void readObject(Object object) {
        String sClassName = object.getClass().getSimpleName();
        switch (sClassName) {
            case "JSONObject" -> ((JSONObject) object).keySet().forEach((key) ->
            {System.out.println(key);readObject(((JSONObject) object).get(key));});
            case "JSONArray" -> ((JSONArray) object).forEach(this::readObject);
            case "String", "Float", "Integer", "Double", "Number", "Long",
                    "BigInteger", "BigDecimal" -> System.out.println(object);
        }
    }
    /**
     * Read the JSON by key.
     */
    public void readByKey() {
        ArrayList<Person> alPersons = new ArrayList<>();
        JSONObject joPerson = (JSONObject) this.jsonObject.get("person1");
        Person cPerson = new Person();
        cPerson.setFirstName((String) joPerson.get("firstName"));
        cPerson.setLastName((String) joPerson.get("lastName"));
        cPerson.setAge((Integer) joPerson.get("age"));
        alPersons.add(cPerson);
        joPerson = (JSONObject) this.jsonObject.get("person2");
        cPerson = new Person();
        cPerson.setFirstName((String) joPerson.get("firstName"));
        cPerson.setLastName((String) joPerson.get("lastName"));
        cPerson.setAge((Integer) joPerson.get("age"));
        alPersons.add(cPerson);
        JSONArray jaPhones = (JSONArray) this.jsonObject.get("phoneNumbers");
        int index = 0;
        for (Object oValue: jaPhones) {
            Phone phone = new Phone();
            phone.setType(((JSONObject) oValue).getString("type"));
            phone.setPhoneNumber(((JSONObject) oValue).getString("phone-number"));
            alPersons.get(index).setPhone(phone);
            index++;
        }
        alPersons.forEach(System.out::println);
    }
    /**
     * Create a JSON from a person.
     */
    public void createJSON() {
        Person cPerson = new Person();
        cPerson.setFirstName("Elio");
        cPerson.setLastName("Perez");
        cPerson.setAge(31);
        Phone cPhone = new Phone();
        cPhone.setType("Mobile");
        cPhone.setPhoneNumber("561-534-5678");
        cPerson.setPhone(cPhone);
        JSONObject joPerson = new JSONObject();
        joPerson.put("first-name", cPerson.getFirstName());
        joPerson.put("last-name", cPerson.getLastName());
        joPerson.put("age", cPerson.getAge());
        JSONObject joMain = new JSONObject();
        joMain.put("person", joPerson);
        try {
            File fOutput = new File("src/resources/json/json_output_file.json");
            FileWriter fwFile = new FileWriter(fOutput);
            fwFile.write(joMain.toString());
            fwFile.flush();
            fwFile.close();
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
    public Person() {}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public Integer getAge() {return age;}
    public void setAge(Integer age) {this.age = age;}
    public Phone getPhone() {return this.phone;}
    public void setPhone(Phone phone) {this.phone = phone;}
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
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}
    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    @Override
    public String toString() {
        return "[" +
                " type=" + this.getType() +
                ", phoneNumber=" + this.getPhoneNumber() +
                " ]";
    }
}
