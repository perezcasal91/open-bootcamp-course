package com.perezcasal.initspring;

import com.perezcasal.initspring.controllers.BooksController;
import com.perezcasal.initspring.entities.BookEntity;
import com.perezcasal.initspring.external.BookBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class InitSpringApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(InitSpringApplication.class, args);

		BooksController booksController = applicationContext.getBean(BooksController.class);

		BookEntity book1 = new BookBuilder()
				.setTitle("Spring 1")
				.setAuthor("Elio")
				.setPages(10)
				.setPrice(1.2)
				.setReleaseDate(LocalDate.of(2022, 12, 30))
				.setOnline(true)
				.build();

		BookEntity book2 = new BookBuilder()
				.setTitle("Spring 2")
				.setAuthor("Daylen")
				.setPages(12)
				.setPrice(1.5)
				.setReleaseDate(LocalDate.of(2022, 12, 30))
				.setOnline(true)
				.build();

		booksController.save(book1);
		booksController.save(book2);

		booksController.findAll().forEach(System.out::println);
	}

}
