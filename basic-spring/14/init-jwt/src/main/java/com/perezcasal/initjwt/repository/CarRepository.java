package com.perezcasal.initjwt.repository;

import com.perezcasal.initjwt.domain.CarEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

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

}
