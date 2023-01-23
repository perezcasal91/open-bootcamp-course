package com.perezcasal.initjwt.controllers;

import com.perezcasal.initjwt.domain.CarEntity;
import com.perezcasal.initjwt.dto.CarMessageDTO;
import com.perezcasal.initjwt.security.payload.MessageResponse;
import com.perezcasal.initjwt.services.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@Tag(name = "Car Controller")
public class CarController {
    @Autowired
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @Operation(summary = "Add Car", description = "Add a new car to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarMessageDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "405", description = "Invalid input"),
            @ApiResponse(responseCode = "406", description = "Element exists.")
    })
    @PostMapping(value = "/cars/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CarMessageDTO> save(@RequestBody CarEntity newCar) {

        if (newCar.getId() != null) {
            return ResponseEntity.badRequest()
                    .body(new CarMessageDTO("Trying to add a car with id, use instead the method Update."));
        }

        if (carService.isAnyMatch(newCar)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new CarMessageDTO("Trying to add a car that already exist."));
        }

        return ResponseEntity
                .ok(new CarMessageDTO("Car saved successfully!", carService.save(newCar)));
    }

    @Operation(summary = "Update Car", description = "Update a car from the database given an id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarMessageDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found."),
            @ApiResponse(responseCode = "405", description = "Invalid input"),
            @ApiResponse(responseCode = "406", description = "Element with different id.")
    })
    @PutMapping(value = "/cars/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CarMessageDTO> update(@RequestBody CarEntity newCar, @PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body(new CarMessageDTO("The id can not be null."));
        }
        var optionalCar = carService.findById(id);
        if (optionalCar.isPresent()) {
            CarEntity car = optionalCar.get();
            if (newCar.getId() == null) {
                return ResponseEntity
                        .ok(new CarMessageDTO("Car updated successfully!", carService.update(car, newCar)));
            } else {
                if (newCar.getId().equals(id)) {
                    return ResponseEntity
                            .ok(new CarMessageDTO("Car updated successfully!", carService.update(car, newCar)));
                } else {
                    return  ResponseEntity
                            .status(HttpStatus.NOT_ACCEPTABLE)
                            .body(new CarMessageDTO("Not acceptable: Trying to update a car with different id," +
                                    " carId=" + car.getId() + " newCarId=" + newCar.getId()));
                }
            }
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new CarMessageDTO
                            ("Not found: Could not found the car you trying to update, use instead the method Save."));
        }
    }

    @Operation(summary = "Delete Car", description = "Delete a car from the database given an id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "405", description = "Invalid input")
    })
    @DeleteMapping(value = "/cars/{id}")
    public void delete(@PathVariable Long id) {
        carService.deleteById(id);
    }

    @Operation(summary = "Delete All Cars", description = "Delete all cars from the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    @DeleteMapping(value = "/cars")
    public void deleteAll() {
        carService.deleteAll();
    }

    @Operation(summary = "Find Car", description = "Find a car from the database given an id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarEntity.class))),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found."),
            @ApiResponse(responseCode = "405", description = "Invalid input")
    })
    @GetMapping(value = "/cars/{id}", produces = "application/json")
    public ResponseEntity<CarEntity> get(@PathVariable Long id) {
        var optionalCar = carService.findById(id);
        return optionalCar.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @Operation(summary = "Find All Cars", description = "Find all cars from the database.", parameters = { @Parameter(in = ParameterIn.HEADER, name = "token", description = "Jwt Token") })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarEntity.class)))
    })
    @GetMapping(value = "/cars", produces = "application/json")
    public List<CarEntity> getAll() {
        return carService.findAll();
    }
}
