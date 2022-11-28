package concepts;

import java.io.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class DataEntryMain {
    public static void main(String[] args) {
        inputStreamFileReadAll();
        inputStreamFileReadByArray();
        bufferStreamFileReadAll();
        bufferStreamFileReadByArray();
    }
    private static void inputStreamFileReadAll() {
        try {
            InputStream inputFile = new FileInputStream("src/resources/doc/FileStream.txt");
            byte [] data = inputFile.readAllBytes();
            for (byte b: data) {
                System.out.print((char) b);
            }
        } catch (FileNotFoundException fileNotFoundException){
            System.out.println(fileNotFoundException.getMessage());
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }
    private static void inputStreamFileReadByArray() {
        try {
            InputStream inputFile = new FileInputStream("src/resources/doc/FileStream.txt");
            byte[] data = new byte[5];
            int d = inputFile.read(data);
            while (d != -1) {
                for (byte c: data) {
                    System.out.print((char) c);
                }
                d = inputFile.read(data);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }
    private static void bufferStreamFileReadAll() {
        try {
            InputStream inputFile = new FileInputStream("src/resources/doc/FileStream.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputFile);
            byte [] data = bufferedInputStream.readAllBytes();
            for (byte b: data) {
                System.out.print((char) b);
            }
        } catch (FileNotFoundException fileNotFoundException){
            System.out.println(fileNotFoundException.getMessage());
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }
    private static void bufferStreamFileReadByArray() {
        try {
            InputStream inputFile = new FileInputStream("src/resources/doc/FileStream.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputFile);
            int d = bufferedInputStream.read();
            while (d != -1) {
                System.out.print((char) d);
                d = inputFile.read();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }
}
