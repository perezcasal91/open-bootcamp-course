package com.perezcasal.initspring.services;

import com.perezcasal.initspring.entities.LaptopEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LaptopService {
    LaptopEntity save(LaptopEntity newLaptop);
    void update(LaptopEntity newLaptop, Long id);
    void delete(Long id);
    LaptopEntity findOneById(Long id);
    List<LaptopEntity> findAll();
}
