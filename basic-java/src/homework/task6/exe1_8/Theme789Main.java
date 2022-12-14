package homework.task6.exe1_8;

import java.io.*;
import java.util.*;

public class Theme789Main {
    public static void main(String[] args) {
        // Default Exe
        System.out.println(reverse("hello world"));
        // 1 Exe
        stringArray();
        // 2 Exe
        printArray(createArray());
        // 3 Exe
        vectorHandler();
        // 4 Exe
        vectorInsertion();
        // 5 Exe
        stringArrayListIntoLinkedList();
        // 6 Exe
        insertIntoArrayList();
        // 7 Exe
        divideByZero(5, 0);
        divideByZero(5, 2);
        // 8
        File inputFile = new File("src/homework/task6/InputFile.txt");
        File outputFile = new File("src/homework/task6/OutputFile.txt");
        copyFile(inputFile, outputFile);
    }
    public static String reverse(String text) {
        System.out.println("Default Exe");
        StringBuilder sbReverse = new StringBuilder();
        for (int i = text.length() - 1; i >= 0 ; i--) {
            sbReverse.append(text.charAt(i));
        }
        return sbReverse.toString();
    }
    public static void stringArray() {
        System.out.println("Exe 1");
        String [] aStringArray = {"Hi", "Hello", "Good Night", "Good Afternoon", "Good Evening", "Night"};
        for (int i = 0; i < aStringArray.length; i++) {
            if (i != aStringArray.length - 1) {
                System.out.print(aStringArray[i] + ",");
            } else {
                System.out.println(aStringArray[i]);
            }
        }
    }
    private static int[][] createArray() {
        int [][] abResultArray = new int[5][5];
        Random cRandom = new Random();
        for (int i = 0; i < abResultArray.length; i++) {
            for (int j = 0; j < abResultArray[i].length; j++) {
                abResultArray[i][j] = cRandom.nextInt(1,10);
            }
        }
        return abResultArray;
    }
    private static void printArray(int [][] numbers) {
        System.out.println("Exe 2");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("File:" + i);
            for (int j = 0; j < numbers[i].length; j++) {
                if (j != numbers[i].length -1) {
                    System.out.print("Index:" + j + " Value:" + numbers[i][j] + " ");
                } else {
                    System.out.print("Index:" + j + " Value:" + numbers[i][j]);
                }
            }
            System.out.println();
        }
    }
    private static void vectorHandler() {
        System.out.println("Exe 3");
        Vector<String> vStrings = new Vector<>();
        for (int i = 1; i < 6; i++) {
            vStrings.add("Vector:" + i);
        }
        vStrings.remove(1);
        vStrings.remove(2);
        for (String value : vStrings) {
            System.out.println(value);
        }
    }

    private static void vectorInsertion() {
        System.out.println("Exe 4");
        System.out.print
                ("""
            The default capacity of the Vector is 10, so if we try to add more elements beyond the capacity, the class
            Vector would have to resize the Array behind, so in order to do that, it's create a new Array with the
            capacity increased by 10 more than original Array, and then copy all the elements from the original Array
            to the new one, and then assign the new Array to the original one, so that operation take too long
            operational time, that's the problem with the Vectors when we don't know the initial capacity, in other
            words, the quantity of the elements that we want to insert into the Vector. So for this particular exercise
            we know the initial capacity, it is 1000, so we can initialize the Vector in that capacity, so for the first
            time we insert that problem would not happen.
                """);
        Vector<Integer> vIntegers = new Vector<>(1000);
        System.out.println("Vector Capacity: " + vIntegers.capacity());
    }
    private static void stringArrayListIntoLinkedList() {
        System.out.println("Exe 5");
        ArrayList<String> alStrings = new ArrayList<>();
        alStrings.add("Jon");
        alStrings.add("Kyle");
        alStrings.add("Lyn");
        alStrings.add("Jess");
        LinkedList<String> llStrings = new LinkedList<>(alStrings);
        for (int i = 0; i < llStrings.size(); i++) {
            System.out.println("ArrayList Value: " + alStrings.get(i));
            System.out.println("LinkedList Value: " + llStrings.get(i));
        }
    }
    private static void insertIntoArrayList() {
        System.out.println("Exe 6");
        ArrayList<Integer> alIntegers = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            if (i %  2 == 0) {
                alIntegers.add(i);
            }
        }
        System.out.print("Integer Array Values: ");
        for (int i = 0; i < alIntegers.size(); i++) {
            if (i != alIntegers.size() - 1) {
                System.out.print(alIntegers.get(i) + " ");
            } else System.out.print(alIntegers.get(i));
        }
    }
    private static void divideByZero(int a, int b) {
        System.out.println("Exe 7");
        try {
            if (numberException(b)) {
                System.out.println("Division is: " + a / b);
                System.out.println("Code Demo");
            }
        } catch (ArithmeticException exception) {
            System.out.println("Exe 7");
            System.out.println(exception.getMessage());
        }
    }
    private static boolean numberException(int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("This can not be done");
        }
        return true;
    }
    private static void copyFile(File inputFile, File outputFile) {
        System.out.println("Exe 8");
        try {
            if (inputFile.isFile()) {
                InputStream isInput = new FileInputStream(inputFile);
                PrintStream psPrint = new PrintStream(outputFile);
                byte [] read = isInput.readAllBytes();
                psPrint.write(read);
                psPrint.flush();
                closeStream(isInput, psPrint);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void closeStream(InputStream fileInputStream, PrintStream printStream) throws IOException {
        System.out.println("The copy was successfully");
        printStream.close();
        fileInputStream.close();
    }
}
