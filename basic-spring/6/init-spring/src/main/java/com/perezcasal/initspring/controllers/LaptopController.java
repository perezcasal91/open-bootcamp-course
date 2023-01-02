package com.perezcasal.initspring.controllers;

import com.perezcasal.initspring.entities.LaptopEntity;
import com.perezcasal.initspring.services.LaptopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {
    LaptopService laptopService;

    public LaptopController(LaptopService booksService) {
        this.laptopService = booksService;
    }

    @PostMapping(
            value = "/api/laptops/add",
            consumes = "application/json")
    public ResponseEntity<LaptopEntity> save(@RequestBody LaptopEntity newLaptop) {
        LaptopEntity laptop = laptopService.save(newLaptop);
        return laptop == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(laptop);
    }

    @PutMapping(
            value = "/api/laptops/{id}",
            consumes = "application/json")
    public void update(@RequestBody LaptopEntity newLaptop, @PathVariable Long id) {
        laptopService.update(newLaptop, id);
    }

    @DeleteMapping(value = "/api/laptops/{id}")
    public void delete(@PathVariable Long id) {
        laptopService.delete(id);
    }

    @GetMapping(
            value = "/api/laptops/{id}",
            produces = "application/json")
    public ResponseEntity<LaptopEntity> findById(@PathVariable Long id) {
        LaptopEntity laptop = laptopService.findOneById(id);
        return laptop == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(laptop);
    }

    @GetMapping(
            value = "/api/laptops",
            produces = "application/json")
    public List<LaptopEntity> findAll() {
        return laptopService.findAll();
    }
}
