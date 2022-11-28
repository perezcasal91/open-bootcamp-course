package concepts;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerMain {
    public static void main(String[] args) {
        boolean exit = false;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println
                    ("""
                    Select an Option
                        1-Type a Number to show
                        2-Type a Text to show
                        3-Exit"""
                    );
            try {
                int option = scanner.nextInt();
                switch (option) {
                    case 1 -> {
                        System.out.println("Now type a Number");
                        try {
                            int intOption = scanner.nextInt();
                            System.out.println("The Number that you just type is: " + intOption);
                        } catch (InputMismatchException inputMismatchException) {
                            System.out.println("You have to enter a Number");
                        }
                    }
                    case 2 -> {
                        System.out.println("Now type a Text");
                        String stringOption = scanner.next();
                        System.out.println("The Text that you just type is: " + stringOption);
                    }
                    case 3 -> {
                        exit = true;
                        System.out.println("Exiting");
                    }
                    default -> System.out.println("You have to select a Option: 1, 2 or 3");
                }
            } catch (InputMismatchException inputMismatchException){
                System.out.println("You have to enter a number: 1 or 2");
            }
        } while (!exit);
    }
}
