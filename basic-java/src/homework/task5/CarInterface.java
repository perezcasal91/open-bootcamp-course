package homework.task5;

import java.util.List;

public interface CarInterface {
    public Car createCar(Integer id, String color, String manufacturer, String model, Double weight, Float size, Integer speed);
    public void saveCar(Integer id, String color, String manufacturer, String model, Double weight, Float size, Integer speed);
    public void saveCar(Car car);
    public Car updateCar(Car car, String color, String manufacturer, String model, Double weight, Float size, Integer speed);
    public void updateCar(Car car, Car updated);
    public void updateCar(Integer id, Car updated);
    public void deleteCar(Car car);
    public Car findCarById(Integer id);
    public boolean contain(Car car);
    public List<Car> findAll();
}
