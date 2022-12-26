package homework.task2.services.file;

import java.util.ArrayList;
import java.util.List;

public interface FileService {

    ArrayList<String> readFile();

    void addLine(String line);

    void deleteLine(List<String> lines);
}
