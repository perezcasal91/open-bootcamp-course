package concepts;

import java.io.*;

/**
 * Example of a read and write a text file.
 */
public class ReadWriteFilesMain {
    public static void main(String[] args) {
        File fInputFile = new File("src/resources/doc/FileStream.txt");
        System.out.println();
        readFileByLine(fInputFile);
        writeFileFromTheBeginning(fInputFile);
        writeFileFromTheEnd(fInputFile);
        readFileByByte(fInputFile);
        copyFileByByte(fInputFile);
        copyFileByAllByte(fInputFile);
    }
    /**
     * Read a text file, it's read line by line,
     * using a FileReader and BufferedReader.
     * @param file text file to read.
     */
    private static void readFileByLine(File file) {
        try {
            if (file.isFile()) {
                FileReader frFile = new FileReader(file);
                BufferedReader brBuffered= new BufferedReader(frFile);
                String sLine = brBuffered.readLine();
                while (sLine != null) {
                    System.out.println(sLine);
                    sLine = brBuffered.readLine();
                }
                frFile.close();
                brBuffered.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Read a text file, it's read by byte,
     * using a FileInputStream and BufferedInputStream.
     * @param file text file to read.
     */
    private static void readFileByByte(File file) {
        try {
            if (file.isFile()) {
                FileInputStream fisFile = new FileInputStream(file);
                BufferedInputStream bisBuffered = new BufferedInputStream(fisFile);
                int iRead = bisBuffered.read();
                while (iRead != -1) {
                    System.out.print((char) iRead);
                    iRead = bisBuffered.read();
                }
                fisFile.close();
                bisBuffered.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Write a text file, using a FileWriter.
     * @param file text file to write.
     */
    private static void writeFileFromTheEnd(File file) {
        try {
            if (file.isFile()) {
                FileWriter fwFile = new FileWriter(file);
                String sNewText = " Line File Writer Example\n";
                for (int i = 1; i < 6; i++) {
                    fwFile.write(i + sNewText);
                }
                fwFile.flush();
                fwFile.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Write a text file, using a PrintWriter.
     * @param file text file to write.
     */
    private static void writeFileFromTheBeginning(File file) {
        try {
            if (file.isFile()) {
                PrintWriter pwPrint = new PrintWriter(file);
                String sNewText = " Line Print Writer Example\n";
                for (int i = 1; i < 6; i++) {
                    pwPrint.write(i + sNewText);
                }
                pwPrint.flush();
                pwPrint.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Copy the entry text file to another a text file,
     * using a FileReader and PrintWriter.
     * @param file text file to write.
     */
    private static void copyFileByByte(File file) {
        try {
            if (file.isFile()) {
                String sDestinyFilePath = file.getParentFile().getPath()
                        .replace("\\", "/") + "/FileCopy.txt";
                FileReader frFile = new FileReader(file);
                PrintWriter pwPrinter = new PrintWriter(sDestinyFilePath);
                int iRead = frFile.read();
                while (iRead != -1) {
                    pwPrinter.write(iRead);
                    iRead = frFile.read();
                }
                pwPrinter.flush();
                pwPrinter.close();
                frFile.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Copy the entry text file to another a text file,
     * using a FileInputStream and PrintStream.
     * @param file text file to write.
     */
    private static void copyFileByAllByte(File file) {
        try {
            if (file.isFile()) {
                String sDestinyFilePath = file.getParentFile().getPath()
                        .replace("\\", "/") + "/FileCopy.txt";
                FileInputStream fisFile = new FileInputStream(file);
                PrintStream psPrint = new PrintStream(sDestinyFilePath);
                byte [] read = fisFile.readAllBytes();
                psPrint.write(read);
                psPrint.flush();
                psPrint.close();
                fisFile.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
