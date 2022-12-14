package com.springboot.springreststarting.databases;

import java.util.ArrayList;
import java.util.List;

public class CarDataBase {
    private final List<Object> dataBase;
    public CarDataBase(){
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
    private int getIndex(Object element){
        return this.dataBase.indexOf(element);
    }
    public void delete(Object element){
        this.dataBase.remove(element);
    }
    public boolean contain(Object element){
        return this.dataBase.contains(element);
    }
    public List<Object> getAll(){
        return this.dataBase;
    }
}
