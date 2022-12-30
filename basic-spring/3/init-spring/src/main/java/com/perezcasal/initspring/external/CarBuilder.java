package com.perezcasal.initspring.external;

import com.perezcasal.initspring.entities.CarEntity;
import org.springframework.stereotype.Component;

@Component
public class CarBuilder {
    private final CarEntity car;
    public CarBuilder() {
        this.car = new CarEntity();
    }

    public CarBuilder setId(Long id) {
        car.setId(id);
        return this;
    }

    public CarBuilder setModel(String model) {
        car.setModel(model);
        return this;
    }

    public CarBuilder setManufacturer(String manufacturer) {
        car.setManufacturer(manufacturer);
        return this;
    }

    public CarBuilder setColor(String color) {
        car.setColor(color);
        return this;
    }

    public CarBuilder setYear(Integer year) {
        car.setYear(year);
        return this;
    }

    public CarEntity build() {
        return car;
    }
}
