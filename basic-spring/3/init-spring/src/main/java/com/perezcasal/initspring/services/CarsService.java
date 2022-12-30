package com.perezcasal.initspring.services;

import com.perezcasal.initspring.entities.CarEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarsService {
    void save(CarEntity car);
    List<CarEntity> findAll();
}
