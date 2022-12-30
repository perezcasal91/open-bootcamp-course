package com.perezcasal.initspring.services;

import com.perezcasal.initspring.entities.CarEntity;
import com.perezcasal.initspring.repositories.CarsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsServiceImplement implements CarsService{
    CarsRepository carsRepository;

    public CarsServiceImplement(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public void save(CarEntity car) {
        carsRepository.save(car);
    }

    @Override
    public List<CarEntity> findAll() {
        return carsRepository.findAll();
    }
}
