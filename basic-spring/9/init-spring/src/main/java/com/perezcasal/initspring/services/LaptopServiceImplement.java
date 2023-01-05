package com.perezcasal.initspring.services;

import com.perezcasal.initspring.entities.LaptopEntity;
import com.perezcasal.initspring.repositories.LaptopRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopServiceImplement implements LaptopService {
    @Autowired
    private final LaptopRepository laptopRepository;
    private final Logger logger;

    public LaptopServiceImplement(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
        this.logger = LoggerFactory.getLogger(LaptopServiceImplement.class);
    }

    /**
     * Save a New Laptop into the H2 Database using JPA.
     * @param newLaptop Laptop Entity
     * @return LaptopEntity - The response.
     */
    @Override
    public LaptopEntity save(LaptopEntity newLaptop) {
        logger.info("Call to the function save.");
        if (isAnyMatch(newLaptop)) {
            logger.warn("The Laptop you are trying to add already exist.");
            return null;
        }
       return laptopRepository.save(newLaptop);
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
     * Update an existing Laptop into the Database using JPA
     * @param newLaptop Laptop Entity
     * @param id Primary key
     * @return LaptopEntity - The response.
     */
    @Override
    public LaptopEntity update(LaptopEntity newLaptop, Long id) {
        return laptopRepository.findById(id)
                .map(book -> {
                    updateFromNewBook(book, newLaptop);
                    return laptopRepository.save(book);
                })
                .orElseGet(() -> {
                    newLaptop.setId(id);
                    return laptopRepository.save(newLaptop);
                });
    }

    private void updateFromNewBook(LaptopEntity laptop, LaptopEntity newLaptop) {
        laptop.setBrand(newLaptop.getBrand());
        laptop.setStorage(newLaptop.getStorage());
        laptop.setPrice(newLaptop.getPrice());
        laptop.setReleaseDate(newLaptop.getReleaseDate());
        laptop.setWifi(newLaptop.getWifi());
    }

    /**
     * Delete a laptop from the Database using JPA.
     * @param id Primary key
     */
    @Override
    public void delete(Long id) {
        laptopRepository.deleteById(id);
    }

    /**
     * Delete all laptops from the Database using JPA.
     */
    @Override
    public void deleteAll() {
        laptopRepository.deleteAll();
    }

    /**
     * Find one laptop into the Database using JPA.
     * @param id Primary key
     * @return Laptop Entity
     */
    @Override
    public LaptopEntity findOneById(Long id) {
        return laptopRepository.findById(id).orElse(null);
    }

    /**
     * Find all the laptops are into the Database using JPA.
     * @return List of Laptop Entity
     */
    @Override
    public List<LaptopEntity> findAll() {
        return laptopRepository.findAll();
    }
}
