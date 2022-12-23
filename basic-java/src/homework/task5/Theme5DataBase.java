package homework.task5;

import java.util.ArrayList;
import java.util.List;

public class Theme5DataBase {
    private final List<Object> dataBase;
    public Theme5DataBase(){
        this.dataBase = new ArrayList<>();
    }
    public void add(Object element){
        this.dataBase.add(element);
    }
    public void update(Object element, Object updated) {
        int index = dataBase.indexOf(element);
        if(index != -1) {
            dataBase.set(index, updated);
        } else {
            System.out.println("The update wasn't successfully, the element not exist in the Data Base");
        }
    }
    public void delete(Object element){
        this.dataBase.remove(element);
    }
    public int getIndex(Object element){
        return this.dataBase.indexOf(element);
    }
    public boolean contain(Object element){
        return this.dataBase.contains(element);
    }
    public List<Object> getAll(){
        return this.dataBase;
    }

}
