package com.perezcasal.laptopdeploy.services;

import com.perezcasal.laptopdeploy.entities.LaptopEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface LaptopService {
    ResponseEntity<LaptopEntity> save(LaptopEntity newLaptop);
    ResponseEntity<LaptopEntity> update(LaptopEntity newLaptop, Long id);
    void delete(Long id);
    void deleteAll();
    ResponseEntity<LaptopEntity> findOneById(Long id);
    List<LaptopEntity> findAll();
}
