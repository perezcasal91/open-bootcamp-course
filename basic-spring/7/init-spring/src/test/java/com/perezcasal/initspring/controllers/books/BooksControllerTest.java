package com.perezcasal.initspring.controllers.books;

import com.perezcasal.initspring.entities.BookEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BooksControllerTest {
    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;
    private ResponseEntity<BookEntity> responseEntity;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void saveTest() {
        SaveBookControllerTest saveBookControllerTest = new SaveBookControllerTest(testRestTemplate);
        saveBookControllerTest.saveTest1();
        saveBookControllerTest.saveTest2();
        saveBookControllerTest.saveTest3();
        saveBookControllerTest.saveTest4();
        saveBookControllerTest.saveTest5();
    }

    @Test
    void updateTest() {
        UpdateBookControllerTest updateBookControllerTest = new UpdateBookControllerTest(testRestTemplate);
        updateBookControllerTest.updateTest1();
        updateBookControllerTest.updateTest2();
        updateBookControllerTest.updateTest3();
        updateBookControllerTest.updateTest4();
        updateBookControllerTest.updateTest5();
    }

    @Test
    void deleteTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Delete book.");

        testRestTemplate.delete("/api/books/3", BookEntity.class);

        responseEntity = testRestTemplate.getForEntity("/api/books/1", BookEntity.class);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void deleteAllTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Delete all books.");

        testRestTemplate.delete("/api/books", BookEntity.class);

        ResponseEntity<BookEntity[]> responseListOfEntity = testRestTemplate.getForEntity("/api/books", BookEntity[].class);
        var booksList = List.of(Objects.requireNonNull(responseListOfEntity.getBody()));

        assertEquals(HttpStatus.OK, responseListOfEntity.getStatusCode());
        assertEquals(0, booksList.size());
        System.out.println();
    }

    @Test
    void getTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Book found.");
        save();

        responseEntity = testRestTemplate.getForEntity("/api/books/4", BookEntity.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(4, Objects.requireNonNull(responseEntity.getBody()).getId());
        assertEquals("Life", Objects.requireNonNull(responseEntity.getBody()).getTitle());
        assertEquals("Elio", Objects.requireNonNull(responseEntity.getBody()).getAuthor());
        assertEquals(500, Objects.requireNonNull(responseEntity.getBody()).getPages());
        assertEquals(2.5, Objects.requireNonNull(responseEntity.getBody()).getPrice());
        assertEquals(LocalDate.of(2023, 1, 3),
                Objects.requireNonNull(responseEntity.getBody()).getReleaseDate());
        assertEquals(false, Objects.requireNonNull(responseEntity.getBody()).getOnline());

        System.out.println(responseEntity.getBody());
        System.out.println();

        System.out.println("Staring the Test 2: Book not found.");
        responseEntity = testRestTemplate.getForEntity("/api/books/2", BookEntity.class);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void getAllTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Get all the books");

        ResponseEntity<BookEntity[]> responseListOfEntity = testRestTemplate.getForEntity("/api/books", BookEntity[].class);
        var booksList = List.of(Objects.requireNonNull(responseListOfEntity.getBody()));

        assertEquals(HttpStatus.OK, responseListOfEntity.getStatusCode());
        assertEquals(2, booksList.size());

        booksList.forEach(System.out::println);
        System.out.println();
    }

    private void save() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
       String json = """
                {
                    "title": "Life",
                    "author": "Elio",
                    "pages": 500,
                    "price": 2.5,
                    "releaseDate": "2023-01-03",
                    "online": false
                }
                """;
        HttpEntity<String> httpEntity = new HttpEntity<>(json, httpHeaders);
        responseEntity = testRestTemplate.exchange("/api/books/add", HttpMethod.POST, httpEntity, BookEntity.class);
    }
}