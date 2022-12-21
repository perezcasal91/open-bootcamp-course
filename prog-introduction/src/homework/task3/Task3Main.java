package homework.task3.main;

import homework.task3.module.*;

public class Main {
    public static void main(String[] args) {
        // Creating the object Person
        Person person = new Person();
        // Setting the properties
        person.setAge(30);
        person.setName("Klee");
        person.setPhone("561-275-3058");
        // Showing in the screen
        System.out.println("Person");
        System.out.println(person.getAge());
        System.out.println(person.getName());
        System.out.println(person.getPhone());
    }
}