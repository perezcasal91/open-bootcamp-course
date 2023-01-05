package com.perezcasal.initspring.controllers.books;

import com.perezcasal.initspring.entities.BookEntity;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UpdateBookControllerTest {
    private final TestRestTemplate testRestTemplate;
    private HttpHeaders httpHeaders;
    private String jsonWithoutId;
    private String jsonWithinOtherId;
    private ResponseEntity<BookEntity> responseEntity;
    private HttpEntity<String> httpEntity;

    public UpdateBookControllerTest(TestRestTemplate testRestTemplate) {
        this.testRestTemplate = testRestTemplate;
        initHeaders();
        initJSON();
        save();
    }
    private void initHeaders() {
        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
    }

    private void initJSON() {
        jsonWithoutId = """
                {
                    "title": "Destiny",
                    "author": "Daylen",
                    "pages": 300,
                    "price": 5.5,
                    "releaseDate": "2023-01-04",
                    "online": true
                }
                """;
        jsonWithinOtherId = """
                {
                    "id": 2,
                    "title": "Life",
                    "author": "Elio",
                    "pages": 500,
                    "price": 2.5,
                    "releaseDate": "2023-01-03",
                    "online": false
                }
                """;
    }

    public void updateTest1() {
        System.out.println();
        System.out.println("Staring the Test 1: Normal Update.");

        httpEntity = new HttpEntity<>(jsonWithoutId, httpHeaders);
        responseEntity = testRestTemplate.exchange("/api/books/3", HttpMethod.PUT, httpEntity, BookEntity.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(3, Objects.requireNonNull(responseEntity.getBody()).getId());
        assertEquals("Destiny", Objects.requireNonNull(responseEntity.getBody()).getTitle());
        assertEquals("Daylen", Objects.requireNonNull(responseEntity.getBody()).getAuthor());
        assertEquals(300, Objects.requireNonNull(responseEntity.getBody()).getPages());
        assertEquals(5.5, Objects.requireNonNull(responseEntity.getBody()).getPrice());
        assertEquals(LocalDate.of(2023, 1, 4),
                Objects.requireNonNull(responseEntity.getBody()).getReleaseDate());
        assertEquals(true, Objects.requireNonNull(responseEntity.getBody()).getOnline());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }

    public void updateTest2() {
        System.out.println("Staring the Test 2: Not Found.");

        httpEntity = new HttpEntity<>(jsonWithoutId, httpHeaders);
        responseEntity = testRestTemplate.exchange
                ("/api/books/2", HttpMethod.PUT, httpEntity, BookEntity.class);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }

    public void updateTest3() {
        System.out.println("Staring the Test 3: Different Id.");

        httpEntity = new HttpEntity<>(jsonWithinOtherId, httpHeaders);
        responseEntity = testRestTemplate.exchange
                ("/api/books/3", HttpMethod.PUT, httpEntity, BookEntity.class);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }

    public void updateTest4() {
        System.out.println("Staring the Test 4: Not Id");

        httpEntity = new HttpEntity<>(jsonWithoutId, httpHeaders);
        responseEntity = testRestTemplate.exchange
                ("/api/books/", HttpMethod.PUT, httpEntity, BookEntity.class);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }

    public void updateTest5() {
        System.out.println("Staring the Test 4: Wrong address.");

        httpEntity = new HttpEntity<>(jsonWithoutId, httpHeaders);
        responseEntity = testRestTemplate.exchange
                ("/api/books", HttpMethod.PUT, httpEntity, BookEntity.class);

        assertEquals(HttpStatus.METHOD_NOT_ALLOWED, responseEntity.getStatusCode());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }

    private void save() {
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
        httpEntity = new HttpEntity<>(json, httpHeaders);
        responseEntity = testRestTemplate.exchange("/api/books/add", HttpMethod.POST, httpEntity, BookEntity.class);
    }
}
