package com.perezcasal.initspring;

import com.perezcasal.initspring.controllers.CarsController;
import com.perezcasal.initspring.entities.CarEntity;
import com.perezcasal.initspring.external.CarBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class InitSpringApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(InitSpringApplication.class, args);
		CarsController carsController = applicationContext.getBean(CarsController.class);
		carsController.findAll().forEach(System.out::println);
	}
}
