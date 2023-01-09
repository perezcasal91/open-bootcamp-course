package com.perezcasal.laptopdeploy.repositories;

import com.perezcasal.laptopdeploy.entities.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<LaptopEntity, Long> {}
