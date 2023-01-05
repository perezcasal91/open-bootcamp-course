package com.perezcasal.initspring.controllers;

import com.perezcasal.initspring.entities.LaptopEntity;
import com.perezcasal.initspring.services.LaptopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@Tag(name = "Laptop Controller")
public class LaptopController {
    @Autowired
    private final LaptopService laptopService;

    public LaptopController(LaptopService booksService) {
        this.laptopService = booksService;
    }

    @Operation(summary = "Add Laptop", description = "Add a new laptop to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = LaptopEntity.class))),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping(value = "laptops/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LaptopEntity> save(@RequestBody LaptopEntity newLaptop) {
        LaptopEntity laptop = laptopService.save(newLaptop);
        return laptop == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(laptop);
    }

    @Operation(summary = "Update Laptop", description = "Update a laptop from the database given an id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = LaptopEntity.class))),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "405", description = "Invalid input")
    })
    @PutMapping(value = "laptops/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LaptopEntity> update(@RequestBody LaptopEntity newLaptop, @PathVariable Long id) {
        LaptopEntity laptop = laptopService.update(newLaptop, id);
        return laptop == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(laptop);
    }

    @Operation(summary = "Delete Laptop", description = "Delete a laptop from the database given an id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "204", description = "No content"),
            @ApiResponse(responseCode = "405", description = "Invalid input")
    })
    @DeleteMapping(value = "laptops/{id}")
    public ResponseEntity<LaptopEntity> delete(@PathVariable Long id) {
        laptopService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete All Laptops", description = "Delete all laptops from the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "204", description = "No content")
    })
    @DeleteMapping(value = "laptops")
    public ResponseEntity<LaptopEntity> deleteAll() {
        laptopService.deleteAll();
        return ResponseEntity.noContent().build();
    }
    @Operation(summary = "Find Laptop", description = "Find a laptop from the database given an id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = LaptopEntity.class))),
            @ApiResponse(responseCode = "404", description = "Not found."),
            @ApiResponse(responseCode = "405", description = "Invalid input")
    })
    @GetMapping(value = "laptops/{id}", produces = "application/json")
    public ResponseEntity<LaptopEntity> findById(@PathVariable Long id) {
        LaptopEntity laptop = laptopService.findOneById(id);
        return laptop == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(laptop);
    }

    @Operation(summary = "Find All Laptops", description = "Find all laptops from the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = LaptopEntity.class)))
    })
    @GetMapping(value = "laptops", produces = "application/json")
    public List<LaptopEntity> findAll() {
        return laptopService.findAll();
    }
}
