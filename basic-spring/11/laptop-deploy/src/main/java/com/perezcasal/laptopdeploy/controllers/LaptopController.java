package com.perezcasal.laptopdeploy.controllers;

import com.perezcasal.laptopdeploy.entities.LaptopEntity;
import com.perezcasal.laptopdeploy.services.LaptopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@Tag(name = "Laptop Controller")
public class LaptopController {
    @Autowired
    private final LaptopService laptopService;

    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @Operation(summary = "Add Laptop", description = "Add a new laptop to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = LaptopEntity.class))),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "405", description = "Invalid input"),
            @ApiResponse(responseCode = "406", description = "Element exists.")
    })
    @PostMapping(value = "${app.environment}/laptops/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LaptopEntity> save(@RequestBody LaptopEntity newLaptop) {
       return  laptopService.save(newLaptop);
    }

    @Operation(summary = "Update Laptop", description = "Update a laptop from the database given an id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = LaptopEntity.class))),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found."),
            @ApiResponse(responseCode = "405", description = "Invalid input"),
            @ApiResponse(responseCode = "406", description = "Element with different id.")
    })
    @PutMapping(value = "${app.environment}/laptops/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LaptopEntity> update(@RequestBody LaptopEntity newLaptop, @PathVariable Long id) {
        return laptopService.update(newLaptop, id);
    }

    @Operation(summary = "Delete Laptop", description = "Delete a laptop from the database given an id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "405", description = "Invalid input")
    })
    @DeleteMapping(value = "${app.environment}/laptops/{id}")
    public void delete(@PathVariable Long id) {
        laptopService.delete(id);
    }

    @Operation(summary = "Delete All Laptops", description = "Delete all laptops from the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    @DeleteMapping(value = "${app.environment}/laptops")
    public void deleteAll() {
        laptopService.deleteAll();
    }

    @Operation(summary = "Find Laptop", description = "Find a laptop from the database given an id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = LaptopEntity.class))),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found."),
            @ApiResponse(responseCode = "405", description = "Invalid input")
    })
    @GetMapping(value = "${app.environment}/laptops/{id}", produces = "application/json")
    public ResponseEntity<LaptopEntity> get(@PathVariable Long id) {
        return laptopService.findOneById(id);
    }

    @Operation(summary = "Find All Laptops", description = "Find all laptops from the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = LaptopEntity.class)))
    })
    @GetMapping(value = "${app.environment}/laptops", produces = "application/json")
    public List<LaptopEntity> getAll() {
        return laptopService.findAll();
    }
}
