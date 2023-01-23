package com.perezcasal.initjwt.services;

import com.perezcasal.initjwt.domain.CarEntity;
import com.perezcasal.initjwt.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private static final Integer MIN_DOORS = 3;
    private final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);
    @Autowired
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarEntity> findAll() {
        logger.info("Executing findAll: List of car.");
        return carRepository.findAll();
    }

    @Override
    public Optional<CarEntity> findById(Long id) {
        logger.info("Executing findById: Optional car.");
        return carRepository.findById(id);
    }

    @Override
    public Long count() {
        logger.info("Executing count: Total number of cars.");
        return carRepository.count();
    }

    /**
     * Save a New Car into the Database using JPA.
     * @param newCar Car Entity
     * @return Car Entity - The response.
     */
    @Override
    public CarEntity save(CarEntity newCar) {
        logger.info("Executing save: new car.");
        return carRepository.save(newCar);
    }

    /**
     * Verify if the new car already exist into the Database.
     * @param newCar Car Entity
     * @return Boolean
     */
    @Override
    public boolean isAnyMatch(CarEntity newCar) {
        return carRepository.findAll().stream().anyMatch(laptop -> laptop.equals(newCar));
    }

    /**
     * Update an existing car into the Database using JPA
     * @param oldCar Car Entity
     * @param newCar Car Entity
     * @return Car Entity - The response.
     */
    @Override
    public CarEntity update(CarEntity oldCar, CarEntity newCar) {
        return carRepository.save(updateFromNewCar(oldCar, newCar));
    }

    private CarEntity updateFromNewCar(CarEntity car, CarEntity newCar) {
        car.setManufacturer(newCar.getManufacturer());
        car.setModel(newCar.getModel());
        car.setCc(newCar.getCc());
        car.setDoors(newCar.getDoors());
        car.setYear(newCar.getYear());
        car.setReleaseDate(newCar.getReleaseDate());
        car.setAvailable(newCar.getAvailable());
        return car;
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        carRepository.deleteAll();
    }

    @Override
    public void deleteAll(List<CarEntity> cars) {
        carRepository.deleteAll(cars);
    }

    @Override
    public List<CarEntity> findCarsByManufacturer(String manufacturer) {
        return carRepository.findCarsByManufacturer(manufacturer);
    }

    @Override
    public List<CarEntity> findCarsByModel(String model) {
        return carRepository.findCarsByModel(model);
    }

    @Override
    public List<CarEntity> findCarsByManufacturerAndModel(String manufacturer, String model) {
        return carRepository.findCarsByManufacturerAndModel(manufacturer, model);
    }

    @Override
    public List<CarEntity> findCarsByCc(Double cc) {
        return carRepository.findCarsByCc(cc);
    }

    @Override
    public List<CarEntity> findCarsByDoors(Integer doors) {
        return carRepository.findCarsByDoors(doors);
    }

    @Override
    public List<CarEntity> findCarsByDoorsGreaterThanEqual(Integer doors) {
        if(MIN_DOORS < doors) {
            return new ArrayList<>();
        }
        return carRepository.findCarsByDoorsGreaterThanEqual(doors);
    }

    @Override
    public List<CarEntity> findCarsByYearIn(List<Integer> years) {
        return carRepository.findCarsByYearIn(years);
    }

    @Override
    public List<CarEntity> findCarsByYearBetween(Integer startYear, Integer endYear) {
        return carRepository.findCarsByYearBetween(startYear, endYear);
    }

    @Override
    public List<CarEntity> findCarsByReleaseDate(LocalDate releaseDate) {
        return carRepository.findCarsByReleaseDate(releaseDate);
    }

    @Override
    public List<CarEntity> findCarsByReleaseDateBetween(LocalDate startDate, LocalDate endDate) {
        return carRepository.findCarsByReleaseDateBetween(startDate, endDate);
    }

    @Override
    public List<CarEntity> findCarsByAvailable(Boolean available) {
        return carRepository.findCarsByAvailable(available);
    }

    @Override
    public Long deleteAllByAvailableFalse() {
        return carRepository.deleteAllByAvailableFalse();
    }
}
