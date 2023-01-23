package com.perezcasal.initjwt.services;

import com.perezcasal.initjwt.domain.CarEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CarService {

    List<CarEntity> findAll();
    Optional<CarEntity> findById(Long id);
    Long count();
    CarEntity save(CarEntity car);
    CarEntity update(CarEntity oldCar, CarEntity newCar);
    void deleteById(Long id);
    void deleteAll();
    void deleteAll(List<CarEntity> cars);
    List<CarEntity> findCarsByManufacturer(String manufacturer);
    List<CarEntity> findCarsByModel(String model);
    List<CarEntity> findCarsByManufacturerAndModel(String manufacturer, String model);
    List<CarEntity> findCarsByCc(Double cc);
    List<CarEntity> findCarsByDoors(Integer doors);
    List<CarEntity> findCarsByDoorsGreaterThanEqual(Integer doors);
    List<CarEntity> findCarsByYearIn(List<Integer> years);
    List<CarEntity> findCarsByYearBetween(Integer startYear, Integer endYear);
    List<CarEntity> findCarsByReleaseDate(LocalDate releaseDate);
    List<CarEntity> findCarsByReleaseDateBetween(LocalDate startDate, LocalDate endDate);
    List<CarEntity> findCarsByAvailable(Boolean available);
    Long deleteAllByAvailableFalse();
    boolean isAnyMatch(CarEntity newCar);
}
