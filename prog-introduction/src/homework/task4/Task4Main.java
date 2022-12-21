package homework.task4.main;

import homework.task4.module.*;

public class Main {
    public static void main(String[] args) {
        // Creating the object Client
        Client client = new Client();
        // Setting the properties
        client.setAge(30);
        client.setName("Klee");
        client.setPhone("561-275-3058");
        client.setCredit(720);
        // Showing in the screen
        System.out.println("Client");
        System.out.println(client.getAge());
        System.out.println(client.getName());
        System.out.println(client.getPhone());
        System.out.println(client.getCredit());
        // Creating the object Employee
        Employee employee = new Employee();
        // Setting the properties
        employee.setAge(34);
        employee.setName("Ross");
        employee.setPhone("561-456-3078");
        employee.setSalary(2000);
        // Showing in the screen
        System.out.println("Employee");
        System.out.println(employee.getAge());
        System.out.println(employee.getName());
        System.out.println(employee.getPhone());
        System.out.println(employee.getSalary());
    }
}