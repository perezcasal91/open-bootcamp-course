package homework.task6.exe9.controller.person;

import homework.task6.exe9.model.Person;
import java.util.ArrayList;

public interface PersonInterface {
    void savePerson(Person person);
    ArrayList<String> findAllPersons();
}
