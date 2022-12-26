package com.springboot.springreststarting.services;

import com.springboot.springreststarting.databases.CarDataBase;
import com.springboot.springreststarting.models.CarModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServicesImplement implements CarServicesInterface {
    private final CarDataBase dataBase;
    public CarServicesImplement(){
        this.dataBase = new CarDataBase();
    }
    @Override
    public CarModel createCar(String color, String manufacturer, String model) {
        return new CarModel(color, manufacturer, model);
    }
    @Override
    public void saveCar(String color, String manufacturer, String model) {
        this.saveCar(createCar(color, manufacturer, model));
    }
    @Override
    public void saveCar(CarModel car) {
        this.dataBase.add(car);
    }
    @Override
    public void fillCars(){
        saveCar("black", "Hunday", "XYZ");
        saveCar("white", "Honda", "ASD");
    }
    @Override
    public CarModel updateCar(CarModel car, String color, String manufacturer, String model) {
        car.setColor(color);
        car.setManufacturer(manufacturer);
        car.setModel(model);
        return car;
    }
    @Override
    public void updateCar(CarModel car, CarModel updated) {
        this.dataBase.update(car, updated);
    }
    @Override
    public void deleteCar(CarModel car) {
        this.dataBase.delete(car);
    }
    @Override
    public CarModel findCarByModel(String model) {
        return this.findAll().stream().filter(carModel ->
                carModel.getModel().equalsIgnoreCase(model))
                .findFirst().orElse(null);
    }
    @Override
    public boolean contain(CarModel car) {
        return this.dataBase.contain(car);
    }
    @Override
    public List<CarModel> findAll() {
        return this.dataBase.getAll().stream().map(object-> ((CarModel)object)).toList();
    }
}
