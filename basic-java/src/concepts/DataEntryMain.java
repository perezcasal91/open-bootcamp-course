package concepts;

import java.io.*;

/**
 * Class using the Objects InputStream, BufferedInputStream.
 */
public class DataEntryMain {
    public static void main(String[] args) {
        String sFilePath = "src/resources/doc/FileStream.txt";
        inputStreamFileReadAll(sFilePath);
        inputStreamFileReadByArray(sFilePath);
        bufferStreamFileReadAll(sFilePath);
        bufferStreamFileReadByArray(sFilePath);
    }

    /**
     * Function for read a txt file.
     * The function make use of the object InputStream,
     * and read the file all at a once.
     * @param filePath The address of the file to read.
     */
    private static void inputStreamFileReadAll(String filePath) {
        try (InputStream isInput = new FileInputStream(filePath)) {
            byte [] abyData = isInput.readAllBytes();
            for (byte byValue: abyData) {
                System.out.print((char) byValue);
            }
        } catch (IOException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());
        }
    }
    /**
     * Function for read a txt file.
     * The function make use of the object InputStream,
     * and read the file by steps.
     * @param filePath The address of the file to read.
     */
    private static void inputStreamFileReadByArray(String filePath) {
        try (InputStream isInput = new FileInputStream(filePath)) {
            byte [] abyData = new byte[5];
            int iRead = isInput.read(abyData);
            while (iRead != -1) {
                for (byte byValue: abyData) {
                    System.out.print((char) byValue);
                }
                iRead = isInput.read(abyData);
            }
        } catch (IOException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());
        }
    }
    /**
     * Function for read a txt file.
     * The function make use of the object InputStream, BufferedInputStream,
     * and read the file all at a once.
     * @param filePath The address of the file to read.
     */
    private static void bufferStreamFileReadAll(String filePath) {
        try (InputStream isInput = new FileInputStream(filePath)) {
            BufferedInputStream bisBuffered = new BufferedInputStream(isInput);
            byte [] abyData = bisBuffered.readAllBytes();
            for (byte byValue: abyData) {
                System.out.print((char) byValue);
            }
            bisBuffered.close();
        } catch (IOException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());
        }
    }
    /**
     * Function for read a txt file.
     * The function make use of the object InputStream, BufferedInputStream,
     * and read the file line by line.
     * @param filePath The address of the file to read.
     */
    private static void bufferStreamFileReadByArray(String filePath) {
        try (InputStream isInput = new FileInputStream(filePath)) {
            BufferedInputStream bisBuffered = new BufferedInputStream(isInput);
            int iRead = bisBuffered.read();
            while (iRead != -1) {
                System.out.print((char) iRead);
                iRead = bisBuffered.read();
            }
            bisBuffered.close();
        } catch (IOException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());
        }
    }
}
