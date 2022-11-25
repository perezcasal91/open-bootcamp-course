package concepts;

import java.util.Scanner;

public class IOMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("New Line");
        String firstLine = scanner.nextLine();
        int secondLine =  scanner.nextInt();
        System.out.println(firstLine);
        System.out.println(secondLine);
    }
}
