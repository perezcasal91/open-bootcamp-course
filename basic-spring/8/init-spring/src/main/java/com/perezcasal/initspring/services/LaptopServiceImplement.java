package com.perezcasal.initspring.services;

import com.perezcasal.initspring.entities.LaptopEntity;
import com.perezcasal.initspring.repositories.LaptopRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopServiceImplement implements LaptopService {
    LaptopRepository laptopRepository;
    Logger logger = LoggerFactory.getLogger(LaptopServiceImplement.class);

    public LaptopServiceImplement(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @Override
    public LaptopEntity save(LaptopEntity newLaptop) {
        logger.info("Call to the function save.");
        if (isAnyMatch(newLaptop)) {
            logger.warn("The Laptop you are trying to add already exist.");
            return null;
        }
       return laptopRepository.save(newLaptop);
    }

    private boolean isAnyMatch(LaptopEntity newLaptop) {
        return laptopRepository.findAll().stream().anyMatch(laptop -> laptop.equals(newLaptop));
    }

    @Override
    public void update(LaptopEntity newLaptop, Long id) {
        laptopRepository.findById(id)
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

    @Override
    public void delete(Long id) {
        laptopRepository.deleteById(id);
    }

    @Override
    public LaptopEntity findOneById(Long id) {
        return laptopRepository.findById(id).orElse(null);
    }

    @Override
    public List<LaptopEntity> findAll() {
        return laptopRepository.findAll();
    }
}
