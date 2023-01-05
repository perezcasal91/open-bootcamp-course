package com.perezcasal.initspring.services;

import com.perezcasal.initspring.entities.LaptopEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LaptopService {
    LaptopEntity save(LaptopEntity newLaptop);
    LaptopEntity update(LaptopEntity newLaptop, Long id);
    void delete(Long id);
    void deleteAll();
    LaptopEntity findOneById(Long id);
    List<LaptopEntity> findAll();
}
