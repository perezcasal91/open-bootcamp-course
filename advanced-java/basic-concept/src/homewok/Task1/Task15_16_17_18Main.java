package homewok.Task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Task15_16_17_18Main {
    public static void main(String[] args) {
        System.out.println();
        // Exe 1
        arithmeticException(1,0);
        // Exe 2
        System.out.println();
        try {
            arrayIndexOutOfBounds();
        } catch (Exception exception) {
            exceptionMessage(exception, 0);
        }
        System.out.println();
        // Exe 3
        fileNotFound();
    }
    private static void arithmeticException(int a, int b) {
        try {
            int result = a / b;
            System.out.println(result);
        } catch (Exception exception) {
            exceptionMessage(exception, 0);
        }
    }
    private static void arrayIndexOutOfBounds() {
        int [] numbers = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < 10; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
    private static void fileNotFound() {
        File file = new File("");
        try (InputStream inputStream = new FileInputStream(file)){
            System.out.println(inputStream.read());
        } catch (Exception exception) {
            exceptionMessage(exception, 3);
        }
    }
    private static void exceptionMessage(Exception exception, int stackTraceIndex) {
        System.out.println("The software has generated an exception the type: " + exception.getClass().getSimpleName());
        System.out.println("In the class: " + exception.getStackTrace()[stackTraceIndex].getClassName());
        System.out.println("In the method: " + exception.getStackTrace()[stackTraceIndex].getMethodName());
        System.out.println("In the line: " + exception.getStackTrace()[stackTraceIndex].getLineNumber());
        if (!exception.getMessage().isEmpty()) {
            System.out.println("There is this error: " + exception.getMessage());
        }

    }
}
