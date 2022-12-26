package homework.task2.domain;

import java.util.ArrayList;
import java.util.List;

public class MemoryData {
    private static List<Object> database;
    private static MemoryData memoryData;
    private MemoryData (){}

    public static MemoryData getInstance(){
        if (memoryData == null){
            database = new ArrayList<>();
            memoryData = new MemoryData();
        }
        return memoryData;
    }
    public void save(Object o){database.add(o);}
    public void delete(Object o){database.remove(o);}
    public boolean contains(Object o){
        return database.contains(o);
    }
    public List<Object> getAll(){return database;}
}
