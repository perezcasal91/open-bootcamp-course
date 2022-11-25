package homework.task5;

import java.util.ArrayList;
import java.util.List;

public class Theme5DataBase {
    private List<Object> dataBase;
    public Theme5DataBase(){
        this.dataBase = new ArrayList<>();
    }
    public void add(Object element){
        this.dataBase.add(element);
    }
    public void update(Object element, Object updated){
        int carIndex = dataBase.indexOf(element);
        if(carIndex != -1){
            dataBase.set(carIndex, updated);
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
