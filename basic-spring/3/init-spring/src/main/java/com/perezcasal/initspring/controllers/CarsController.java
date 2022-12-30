package com.perezcasal.initspring.controllers;

import com.perezcasal.initspring.entities.CarEntity;
import com.perezcasal.initspring.services.CarsService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CarsController {
    CarsService carsService;

    public CarsController(CarsService carsService) {
        this.carsService = carsService;
    }

    public void save(CarEntity car) {
        carsService.save(car);
    }

    public List<CarEntity> findAll() {
        return carsService.findAll();
    }
}
