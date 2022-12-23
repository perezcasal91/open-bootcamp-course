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
        boolean bExit = false;
        do {
            PersonInterface cPersonInterface = new PersonImplement();
            AddressInterface cAddressInterface = new AddressImplement();
            PhoneInterface cPhoneInterface = new PhoneImplement();
            Address cAddress = new Address();
            Person cPerson = new Person();
            Scanner cScanner = new Scanner(System.in);
            System.out.println
                    ("""
                    Select an Option:
                        1-Add a person
                        2-List all the persons
                        3-Exit
                    """);
            try {
                int iOption = Integer.parseInt(cScanner.nextLine());
                switch (iOption) {
                    case 1 -> {
                        try {
                            System.out.println("Type the name:");
                            String sName = cScanner.nextLine();
                            cPerson.setName(sName);
                            System.out.println("Type the age:");
                            Integer iAge = Integer.parseInt(cScanner.nextLine());
                            cPerson.setAge(iAge);
                            addressHandler(cAddressInterface, cAddress, cScanner);
                            phoneHandler(cPhoneInterface, cScanner);
                            cPerson.setAddress(cAddress);
                            cPerson.setPhones(cPhoneInterface.getPhones());
                            cPersonInterface.savePerson(cPerson);
                        } catch (InputMismatchException inputMismatchException) {
                            System.out.println("You have to enter a Number");
                        } catch (Exception indexOutOfBoundsException) {
                            System.out.println(indexOutOfBoundsException.getMessage());
                        }
                    }
                    case 2 -> {
                        System.out.println("Listing the Persons");
                        cPersonInterface.findAllPersons().forEach((System.out::println));
                    }
                    case 3 -> {
                        bExit = true;
                        System.out.println("Exiting");
                    }
                    default -> System.out.println("You have to select a Option: 1, 2 or 3");
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("You have to enter a number: 1, 2 or 3");
            } catch (NumberFormatException numberFormatException) {
                System.out.println("You have to select a Option: 1, 2 or 3");
            }
        } while (!bExit);
    }
    private static void addressHandler(AddressInterface addressInterface, Address address, Scanner scanner) {
        System.out.println("For the address of the person first you have to type the Street" +
            "then you must to select the options that we show you in the screen:");
        System.out.println("Type the street:");
        String sStreet = scanner.nextLine();
        address.setStreet(sStreet);
        System.out.println("Select the city:");
        addressInterface.getCities().forEach((key, value) -> System.out.println(key + ":" + value));
        int iCity = Integer.parseInt(scanner.nextLine());
        address.setCity(addressInterface.getCity(iCity));
        System.out.println("Select the state:");
        addressInterface.getStates().forEach((key, value) -> System.out.println(key + ":" + value));
        int iState = Integer.parseInt(scanner.nextLine());
        address.setState(addressInterface.getState(iState));
        System.out.println("Select the country:");
        addressInterface.getCountries().forEach((key, value) -> System.out.println(key + ":" + value));
        int iCountry = Integer.parseInt(scanner.nextLine());
        address.setCountry(addressInterface.getCountry(iCountry));
    }
    private static void phoneHandler(PhoneInterface phoneInterface, Scanner scanner) throws Exception {
        System.out.println("The person has only allowed 5 phones, for done with the phones type 0");
        System.out.println("Phone Format: ___-___-____");
        System.out.println("Type the phones:");
        int iCount = 1;
        while (iCount != 0) {
            String sPhone = scanner.next();
            if (!sPhone.equals("0")) {
                phoneInterface.addPhone(sPhone);
            } else {
                break;
            }
            if (iCount == 6) {
                break;
            }
            iCount++;
        }
    }
}
