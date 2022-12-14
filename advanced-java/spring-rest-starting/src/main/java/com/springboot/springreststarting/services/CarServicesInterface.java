package com.springboot.services;

import com.springboot.models.CarModel;

import java.util.List;

public interface CarServicesInterface {
    CarModel createCar(Integer id, String color, String manufacturer, String model);
    void saveCar(Integer id, String color, String manufacturer, String model);
    void saveCar(CarModel car);
    CarModel updateCar(CarModel car, String color, String manufacturer, String model);
    void updateCar(CarModel car, CarModel updated);
    void updateCar(Integer id, CarModel updated);
    void deleteCar(CarModel car);
    CarModel findCarById(Integer id);
    CarModel findCarByModel(String model);
    boolean contain(CarModel car);
    List<CarModel> findAll();
}
