package com.springboot.springreststarting.services;

import com.springboot.springreststarting.models.CarModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CarServicesInterface {
    CarModel createCar(String color, String manufacturer, String model);
    void saveCar(String color, String manufacturer, String model);
    void saveCar(CarModel car);
    void fillCars();
    CarModel updateCar(CarModel car, String color, String manufacturer, String model);
    void updateCar(CarModel car, CarModel updated);
    void deleteCar(CarModel car);
    CarModel findCarByModel(String model);
    boolean contain(CarModel car);
    List<CarModel> findAll();
}
