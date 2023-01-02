package com.perezcasal.initspring;

import com.perezcasal.initspring.entities.BookEntity;
import com.perezcasal.initspring.external.BookBuilder;
import com.perezcasal.initspring.repositories.BooksRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class InitSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitSpringApplication.class, args);
	}
}
