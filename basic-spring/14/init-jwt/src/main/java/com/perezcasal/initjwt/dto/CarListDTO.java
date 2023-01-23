package com.perezcasal.initjwt.dto;

import com.perezcasal.initjwt.domain.CarEntity;

import java.util.List;

public class CarListDTO {
    private List<CarEntity> cars;
    public CarListDTO() {}
    public List<CarEntity> getCars() {return cars;}
    public void setCars(List<CarEntity> cars) {this.cars = cars;}
}
