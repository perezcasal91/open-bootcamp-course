package homework.task2.services.file;

import homework.task2.domain.FileData;

import java.util.ArrayList;
import java.util.List;

public class FileImplement implements FileService {
    private final FileData fileData;
    public FileImplement() {
        this.fileData = FileData.getInstance();
    }

    @Override
    public ArrayList<String> readFile() {
        return fileData.readFile();
    }

    @Override
    public void addLine(String line) {
        fileData.addLine(line);
    }

    @Override
    public void deleteLine(List<String> lines) {
        fileData.deleteLine(lines);
    }
}
