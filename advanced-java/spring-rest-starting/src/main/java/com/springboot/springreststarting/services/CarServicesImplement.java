package com.springboot.services;

import com.springboot.databases.CarDataBase;
import com.springboot.models.CarModel;

import java.util.List;
import java.util.Objects;

public class CarServicesImplement implements CarServicesInterface {
    private final CarDataBase dataBase;
    public CarServicesImplement(){
        this.dataBase = new CarDataBase();
    }
    @Override
    public CarModel createCar(Integer id, String color, String manufacturer, String model) {
        return new CarModel(id, color, manufacturer, model);
    }
    @Override
    public void saveCar(Integer id, String color, String manufacturer, String model) {
        this.saveCar(createCar(id, color, manufacturer, model));
    }
    @Override
    public void saveCar(CarModel car) {
        this.dataBase.add(car);
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
    public void updateCar(Integer id, CarModel updated) {
        this.dataBase.update(findCarById(id), updated);
    }
    @Override
    public void deleteCar(CarModel car) {
        this.dataBase.delete(car);
    }
    @Override
    public CarModel findCarById(Integer id) {
        return this.findAll().stream().filter(carModel ->
                Objects.equals(carModel.getId(), id))
                .findFirst().orElse(null);
    }
    @Override
    public CarModel findCarByModel(String model) {
        return this.findAll().stream().filter(carModel ->
                Objects.equals(carModel.getModel(), model))
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
