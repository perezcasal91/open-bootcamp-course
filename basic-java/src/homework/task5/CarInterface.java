package homework.task5;

import java.util.List;

public interface CarInterface {
    Car createCar(Integer id, String color, String manufacturer,
                  String model, Double weight, Float size, Integer speed);
    void saveCar(Integer id, String color, String manufacturer,
                 String model, Double weight, Float size, Integer speed);
    void saveCar(Car car);
    Car updateCar(Car car, String color, String manufacturer,
                  String model, Double weight, Float size, Integer speed);
    void updateCar(Car car, Car updated);
    void updateCar(Integer id, Car updated);
    void deleteCar(Car car);
    Car findCarById(Integer id);
    boolean contain(Car car);
    List<Car> findAll();
}
