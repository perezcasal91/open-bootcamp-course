package homework.task6.exe9.ui;


import homework.task6.exe9.controller.address.AddressImplement;
import homework.task6.exe9.controller.address.AddressInterface;
import homework.task6.exe9.controller.person.PersonImplement;
import homework.task6.exe9.controller.person.PersonInterface;
import homework.task6.exe9.controller.phone.PhoneImplement;
import homework.task6.exe9.controller.phone.PhoneInterface;
import homework.task6.exe9.model.Address;
import homework.task6.exe9.model.Person;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exe9Main {
    public static void main(String[] args) {
        PersonInterface personInterface = new PersonImplement();
        AddressInterface addressInterface = new AddressImplement();
        PhoneInterface phoneInterface = new PhoneImplement();
        Address address = new Address();
        Person person = new Person();
        boolean exit = false;
        int keepGoing = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println
                    ("""
                    Select an Option:
                        1-Add a person
                        2-List all the persons
                        3-Exit
                    """);
            try {
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1 -> {
                        try {
                            System.out.println("Type the name:");
                            String name = scanner.nextLine();
                            person.setName(name);
                            System.out.println("Type the age:");
                            Integer age = Integer.parseInt(scanner.nextLine());
                            person.setAge(age);
                            addressHandler(addressInterface, address, scanner);
                            phoneHandler(phoneInterface, scanner);
                            person.setAddress(address);
                            person.setPhones(phoneInterface.getPhones());
                            personInterface.savePerson(person);
                        } catch (InputMismatchException inputMismatchException) {
                            System.out.println("You have to enter a Number");
                        } catch (Exception indexOutOfBoundsException) {
                            System.out.println(indexOutOfBoundsException.getMessage());
                        }
                    }
                    case 2 -> {
                        System.out.println("Listing the Persons");
                        personInterface.findAllPersons().forEach((System.out::println));
                    }
                    case 3 -> {
                        exit = true;
                        System.out.println("Exiting");
                    }
                    default -> System.out.println("You have to select a Option: 1, 2 or 3");
                }
            } catch (InputMismatchException inputMismatchException){
                System.out.println("You have to enter a number: 1, 2 or 3");
            } catch (NumberFormatException numberFormatException){
                System.out.println("You have to select a Option: 1, 2 or 3");
            }
        } while (!exit);
    }
    private static void addressHandler(AddressInterface addressInterface, Address address, Scanner scanner) {
        System.out.println("For the address of the person first you have to type the Street" +
            "then you must to select the options that we show you in the screen:");
        System.out.println("Type the street:");
        String street = scanner.nextLine();
        address.setStreet(street);
        System.out.println("Select the city:");
        addressInterface.getCity().forEach((key, value) -> System.out.println(key + ":" + value));
        int city = Integer.parseInt(scanner.nextLine());
        address.setCity(addressInterface.getCity(city));
        System.out.println("Select the state:");
        addressInterface.getState().forEach((key, value) -> System.out.println(key + ":" + value));
        int state = Integer.parseInt(scanner.nextLine());
        address.setState(addressInterface.getState(state));
        System.out.println("Select the country:");
        addressInterface.getCountry().forEach((key, value) -> System.out.println(key + ":" + value));
        int country = Integer.parseInt(scanner.nextLine());
        address.setCountry(addressInterface.getCountry(country));
    }
    private static void phoneHandler(PhoneInterface phoneInterface, Scanner scanner) throws Exception {
        System.out.println("The person has only allowed 5 phones, for done with the phones type 0");
        System.out.println("Phone Format: ___-___-____");
        System.out.println("Type the phones:");

        int count = 1;
        while (count != 0) {
            String phone = scanner.next();
            if (!phone.equals("0")) {
                phoneInterface.addPhone(phone);
            } else {
                break;
            }
            if (count == 6) {
                break;
            }
            count++;
        }
    }

}
