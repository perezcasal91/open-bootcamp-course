package com.springboot.springreststarting.controllers;

import com.springboot.springreststarting.models.CarModel;
import com.springboot.springreststarting.services.CarServicesInterface;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Path("/")
@Component
public class CarController {
    private CarServicesInterface carServicesInterface;
    public CarController(CarServicesInterface carServicesInterface){
        this.carServicesInterface = carServicesInterface;
        this.carServicesInterface.fillCars();
    }
    @GET
    @Path("/srs/cars")
    @Produces("application/json")
    public List<CarModel> getAllCars(){
        return this.carServicesInterface.findAll();
    }
    @GET
    @Path("/srs/cars/{model}")
    @Produces("application/json")
    public CarModel getCarByModel(@PathParam("model") String model){
        return this.carServicesInterface.findCarByModel(model);
    }
    @POST
    @Path("/srs/cars/add")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addCar(CarModel car){
        this.carServicesInterface.saveCar(car);
        return Response.created(
                URI.create("/srs/cars/" + car.getModel())
        ).build();
    }
}
