package homework.task7.controller;

import homework.task7.model.Car;
import homework.task7.model.CarSize;
import homework.task7.model.CarWeightOrSpeed;

import java.util.List;

public interface CarInterface {
    Car createCar(Integer id, String color, String manufacturer, String model,
                  CarWeightOrSpeed weight, CarSize size, CarWeightOrSpeed speed);
    void saveCar(Integer id, String color, String manufacturer, String model,
                 CarWeightOrSpeed weight, CarSize size, CarWeightOrSpeed speed);
    void saveCar(Car car);
    Car updateCar(Car car, String color, String manufacturer, String model,
                  CarWeightOrSpeed weight, CarSize size, CarWeightOrSpeed speed);
    void updateCar(Car car, Car updated);
    void updateCar(Integer id, Car updated);
    void deleteCar(Car car);
    Car findCarById(Integer id);
    boolean contain(Car car);
    List<Car> findAll();
}
