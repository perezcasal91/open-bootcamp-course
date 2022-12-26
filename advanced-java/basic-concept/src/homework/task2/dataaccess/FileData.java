package homework.task2.dataaccess;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileData {
    private FileWriter fileWriter;
    private File file;
    private static FileData fileData;
    private FileData (){
        initFiles();
    }
    public static FileData getInstance(){
        if (fileData == null){
            fileData = new FileData();
        }
        return fileData;
    }
    private void initFiles() {
        String filePath = "src/homework/task2/resources/users_file.dat";
        this.file = new File(filePath);
        try {
            this.fileWriter = new FileWriter(file.getAbsoluteFile(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<String> readFile() {
        ArrayList<String> stringLineList = new ArrayList<>();

        try (var stringList = Files.lines(file.toPath(), StandardCharsets.UTF_8)) {
            stringList.forEach(stringLineList::add);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        return stringLineList;
    }
    public void addLine(String line) {
        writeLine(line);
    }
    public void deleteLine(List<String> lines) {
        try (PrintWriter ignored = new PrintWriter(file)) {
            lines.forEach(this::addLine);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void writeLine(String line) {
        try {
            fileWriter.write(line + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
