package homework.Task678.singleton.exe1;

import java.util.ArrayList;
import java.util.List;

public class CarDataBaseMain {
    public static void main(String[] args) {
        CarInterface carInterface = new CarImplement();
        CarModel car = new CarModel("XYZ", "Black");
        carInterface.saveCar(car);
        carInterface.findAll().forEach(System.out::println);
    }
}
class CarDataBase {
    private static List<Object> database;
    private static CarDataBase carDataBase;
    private CarDataBase (){}
    public static CarDataBase getInstance(){
        if (carDataBase == null){
            database = new ArrayList<>();
            carDataBase = new CarDataBase();
        }
        return carDataBase;
    }
    public void save(Object o){database.add(o);}
    public List<Object> getAll(){return database;}
}
interface CarInterface {
    void saveCar(CarModel car);
    List<CarModel> findAll();
}
class CarImplement implements CarInterface {
    private final CarDataBase carDataBase;
    public CarImplement (){carDataBase = CarDataBase.getInstance();}
    @Override
    public void saveCar(CarModel car) {carDataBase.save(car);}
    @Override
    public List<CarModel> findAll() {
        return carDataBase.getAll().stream()
                .map(o-> (CarModel)o)
                .toList();
    }
}
class CarModel {
    private String model;
    private String color;
    public CarModel (String model, String color){this.model = model; this.color = color;}
    public String getModel() {return model;}
    public void setModel(String model) {this.model = model;}
    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}
    @Override
    public String toString() {
        return "CarModel { " +
                "model=" + model +
                ", color=" + color +
                " } ";
    }
}