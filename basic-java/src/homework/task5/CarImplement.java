package homework.task5;

import java.util.List;

public class CarImplement implements CarInterface {
    private final Theme5DataBase dataBase;
    public CarImplement(){
        this.dataBase = new Theme5DataBase();
    }
    @Override
    public Car createCar(Integer id, String color, String manufacturer, String model, Double weight, Float size, Integer speed) {
        return new Car(id, color, manufacturer, model, weight, size, speed);
    }
    @Override
    public void saveCar(Integer id, String color, String manufacturer, String model, Double weight, Float size, Integer speed) {
        this.saveCar(createCar(id, color, manufacturer, model, weight, size, speed));
    }
    @Override
    public void saveCar(Car car) {
        this.dataBase.add(car);
    }
    @Override
    public Car updateCar(Car car, String color, String manufacturer, String model, Double weight, Float size, Integer speed) {
        car.setColor(color);
        car.setManufacturer(manufacturer);
        car.setModel(model);
        car.setWeight(weight);
        car.setSize(size);
        car.setSpeed(speed);
        return car;
    }
    @Override
    public void updateCar(Car car, Car updated) {
        this.dataBase.update(car, updated);
    }
    @Override
    public void updateCar(Integer id, Car updated) {
        this.dataBase.update(findCarById(id), updated);
    }
    @Override
    public void deleteCar(Car car) {
        this.dataBase.delete(car);
    }
    @Override
    public Car findCarById(Integer id) {
        for (Object car : this.dataBase.getAll()) {
            if (((Car)car).getId().equals(id)){
                return (Car)car;
            }
        }
        return null;
    }
    @Override
    public boolean contain(Car car) {
        return this.dataBase.contain(car);
    }
    @Override
    public List<Car> findAll() {
        return this.dataBase.getAll().stream().map(object-> ((Car)object)).toList();
    }

}
