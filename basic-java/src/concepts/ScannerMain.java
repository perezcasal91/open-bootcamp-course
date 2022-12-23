package concepts;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class with an example of Scanner.
 * Using some methods.
 */
public class ScannerMain {
    public static void main(String[] args) {
        boolean bExit = false;
        do {
            Scanner cScanner = new Scanner(System.in);
            System.out.println
                    ("""
                    Select an Option
                        1-Type a Number to show
                        2-Type a Text to show
                        3-Exit"""
                    );
            try {
                int iOption = cScanner.nextInt();
                switch (iOption) {
                    case 1 -> {
                        System.out.println("Now type a Number");
                        try {
                            int iInt = cScanner.nextInt();
                            System.out.println("The Number that you just type is: " + iInt);
                        } catch (InputMismatchException inputMismatchException) {
                            System.out.println("You have to enter a Number");
                        }
                    }
                    case 2 -> {
                        System.out.println("Now type a Text");
                        String sString = cScanner.next();
                        System.out.println("The Text that you just type is: " + sString);
                    }
                    case 3 -> {
                        bExit = true;
                        System.out.println("Exiting");
                    }
                    default -> System.out.println("You have to select a Option: 1, 2 or 3");
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("You have to enter a number: 1 or 2");
            }
        } while (!bExit);
    }
}
