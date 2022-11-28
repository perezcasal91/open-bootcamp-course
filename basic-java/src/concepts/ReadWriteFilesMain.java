package concepts;


import java.io.*;

public class ReadWriteFilesMain {
    public static void main(String[] args) {
        File file = new File("src/resources/doc/FileStream.txt");
        System.out.println();
        // Read File
        readFileByLine(file);
        // Write File
        writeFileFromTheBeginning(file);
        writeFileFromTheEnd(file);
        // Read File
        readFileByByte(file);
        // Copy File
        copyFileByByte(file);
        copyFileByAllByte(file);
    }
    private static void readFileByLine(File file) {
        try {
            if (file.isFile()) {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader= new BufferedReader(fileReader);
                String line = bufferedReader.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = bufferedReader.readLine();
                }
                fileReader.close();
                bufferedReader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void readFileByByte(File file) {
        try {
            if (file.isFile()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                int line = bufferedInputStream.read();
                while (line != -1) {
                    System.out.print((char)line);
                    line = bufferedInputStream.read();
                }
                fileInputStream.close();
                bufferedInputStream.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void writeFileFromTheEnd(File file) {
        try {
            if (file.isFile()) {
                FileWriter fileWriter = new FileWriter(file);
                String newText = "Line File Input Stream Example\n";
                for (int i = 10; i < 15; i++) {
                    fileWriter.write(i + newText);
                }
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void writeFileFromTheBeginning(File file) {
        try {
            if (file.isFile()) {
                PrintWriter printWriter = new PrintWriter(file);
                String newText = "Line File Input Stream Example\n";
                for (int i = 10; i < 15; i++) {
                    printWriter.write(i + newText);
                }
                printWriter.flush();
                printWriter.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static void copyFileByByte(File file) {
        try {
            if (file.isFile()) {
                String fileUri = file.getParentFile().getPath().replace("\\", "/") + "/FileCopy.txt";
                FileReader fileReader = new FileReader(file);
                PrintWriter printWriter = new PrintWriter(fileUri);
                int read = fileReader.read();
                while (read != -1) {
                    printWriter.write(read);
                    read = fileReader.read();
                }
                printWriter.flush();
                printWriter.close();
                fileReader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void copyFileByAllByte(File file) {
        try {
            if (file.isFile()) {
                String fileUri = file.getParentFile().getPath().replace("\\", "/") + "/FileCopy.txt";
                FileInputStream fileInputStream = new FileInputStream(file);
                PrintStream printStream = new PrintStream(fileUri);
                byte [] read = fileInputStream.readAllBytes();
                printStream.write(read);
                printStream.flush();
                printStream.close();
                fileInputStream.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
