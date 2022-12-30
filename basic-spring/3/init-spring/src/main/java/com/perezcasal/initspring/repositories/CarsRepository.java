package com.perezcasal.initspring.repositories;

import com.perezcasal.initspring.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<CarEntity, Long> {
}
