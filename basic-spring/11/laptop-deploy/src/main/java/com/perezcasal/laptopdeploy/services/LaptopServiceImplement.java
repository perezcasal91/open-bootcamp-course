package com.perezcasal.laptopdeploy.services;

import com.perezcasal.laptopdeploy.entities.LaptopEntity;
import com.perezcasal.laptopdeploy.repositories.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class LaptopServiceImplement implements LaptopService {
    @Autowired
    private final LaptopRepository laptopRepository;
    private final Logger logger;

    public LaptopServiceImplement(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    /**
     * Save a New Laptop into the H2 Database using JPA.
     * @param newLaptop Laptop Entity
     * @return ResponseEntity - The response.
     */
    @Override
    public ResponseEntity<LaptopEntity> save(LaptopEntity newLaptop) {
        logger.info("Call to the function save.");
        if (newLaptop.getId() != null) {
            logger.warn("Bad request: Trying to add a laptop with id, use instead the method Update.");
            return ResponseEntity.badRequest().build();
        }
        if (isAnyMatch(newLaptop)) {
            logger.warn("Element exist: Trying to add a laptop that already exist.");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
       return ResponseEntity.ok(laptopRepository.save(newLaptop));
    }

    /**
     * Verify if the new laptop already exist into the Database.
     * @param newLaptop Laptop Entity
     * @return Boolean
     */
    private boolean isAnyMatch(LaptopEntity newLaptop) {
        return laptopRepository.findAll().stream().anyMatch(laptop -> laptop.equals(newLaptop));
    }

    /**
     * Update an existing laptop into the Database using JPA
     * @param newLaptop Laptop Entity
     * @param id Primary key
     * @return ResponseEntity - The response.
     */
    @Override
    public ResponseEntity<LaptopEntity> update(LaptopEntity newLaptop, Long id) {
        logger.info("Call to the function update.");
        if (id == null) {
            logger.warn("Bad request: The id can not be null.");
            return ResponseEntity.badRequest().build();
        }
        var optionalLaptop = laptopRepository.findById(id);
        if (optionalLaptop.isPresent()) {
            LaptopEntity laptop = optionalLaptop.get();
            if (newLaptop.getId() == null) {
               return ResponseEntity.ok(laptopRepository.save(updateFromNewLaptop(laptop, newLaptop)));
            } else {
                if (newLaptop.getId().equals(id)) {
                    return ResponseEntity.ok(laptopRepository.save(updateFromNewLaptop(laptop, newLaptop)));
                } else {
                    logger.warn("Not acceptable: Trying to update a laptop with different id," +
                            " laptopId=" + laptop.getId() + " newLaptopId=" + newLaptop.getId());
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
                }
            }
        } else {
            logger.warn("Not found: Could not found the laptop you trying to update, use instead the method Save.");
            return ResponseEntity.notFound().build();
        }
    }

    private LaptopEntity updateFromNewLaptop(LaptopEntity laptop, LaptopEntity newLaptop) {
        laptop.setBrand(newLaptop.getBrand());
        laptop.setStorage(newLaptop.getStorage());
        laptop.setPrice(newLaptop.getPrice());
        laptop.setReleaseDate(newLaptop.getReleaseDate());
        laptop.setWifi(newLaptop.getWifi());
        return laptop;
    }

    /**
     * Delete a laptop from the Database using JPA.
     * @param id Primary key
     */
    @Override
    public void delete(Long id) {
        logger.info("Call to the function delete.");
        laptopRepository.deleteById(id);
    }

    /**
     * Delete all laptops from the Database using JPA.
     */
    @Override
    public void deleteAll() {
        logger.info("Call to the function deleteAll.");
        laptopRepository.deleteAll();
    }

    /**
     * Find one laptop into the Database using JPA.
     * @param id Primary key
     * @return HashMap - The response.
     */
    @Override
    public ResponseEntity<LaptopEntity> findOneById(Long id) {
        logger.info("Call to the function findOneById.");
        if (id == null) {
            logger.warn("Bad request: The id can not be null.");
            return ResponseEntity.badRequest().build();
        }
        return laptopRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Find all the laptops are into the Database using JPA.
     * @return List of Laptop Entity
     */
    @Override
    public List<LaptopEntity> findAll() {
        logger.info("Call to the function findAll.");
        return laptopRepository.findAll();
    }
}
