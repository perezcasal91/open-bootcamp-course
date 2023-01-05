package com.perezcasal.initspring.controllers.books;

import com.perezcasal.initspring.entities.BookEntity;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SaveBookControllerTest {
    private final TestRestTemplate testRestTemplate;
    private HttpHeaders httpHeaders;
    private String jsonWithoutId;
    private String jsonWithoutAttributes;
    private String jsonWithinId;
    private ResponseEntity<BookEntity> responseEntity;
    private HttpEntity<String> httpEntity;

    public SaveBookControllerTest(TestRestTemplate testRestTemplate) {
        this.testRestTemplate = testRestTemplate;
        initHeaders();
        initJSON();
    }
    private void initHeaders() {
        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
    }

    private void initJSON() {
        jsonWithoutId = """
                {
                    "title": "Life",
                    "author": "Elio",
                    "pages": 500,
                    "price": 2.5,
                    "releaseDate": "2023-01-03",
                    "online": false
                }
                """;

        jsonWithoutAttributes = """
                {
                    "title": "Life",
                    "author": "Elio",
                    "pages": 500
                }
                """;

        jsonWithinId = """
                {
                    "id": 1,
                    "title": "Life",
                    "author": "Elio",
                    "pages": 500,
                    "price": 2.5,
                    "releaseDate": "2023-01-03",
                    "online": false
                }
                """;
    }

    public void saveTest1() {
        System.out.println();
        System.out.println("Staring the Test 1");

        httpEntity = new HttpEntity<>(jsonWithoutId, httpHeaders);
        responseEntity = testRestTemplate.exchange("/api/books/add", HttpMethod.POST, httpEntity, BookEntity.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, Objects.requireNonNull(responseEntity.getBody()).getId());
        assertEquals("Life", Objects.requireNonNull(responseEntity.getBody()).getTitle());
        assertEquals("Elio", Objects.requireNonNull(responseEntity.getBody()).getAuthor());
        assertEquals(500, Objects.requireNonNull(responseEntity.getBody()).getPages());
        assertEquals(2.5, Objects.requireNonNull(responseEntity.getBody()).getPrice());
        assertEquals(LocalDate.of(2023, 1, 3),
                Objects.requireNonNull(responseEntity.getBody()).getReleaseDate());
        assertEquals(false, Objects.requireNonNull(responseEntity.getBody()).getOnline());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }

    public void saveTest2() {
        System.out.println("Staring the Test 2");

        httpEntity = new HttpEntity<>(jsonWithoutAttributes, httpHeaders);
        responseEntity = testRestTemplate.exchange
                ("/api/books/add", HttpMethod.POST, httpEntity, BookEntity.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }

    public void saveTest3() {
        System.out.println("Staring the Test 3");

        httpEntity = new HttpEntity<>(jsonWithinId, httpHeaders);
        responseEntity = testRestTemplate.exchange
                ("/api/books/add", HttpMethod.POST, httpEntity, BookEntity.class);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }

    public void saveTest4() {
        System.out.println("Staring the Test 4");

        httpEntity = new HttpEntity<>(jsonWithoutId, httpHeaders);
        responseEntity = testRestTemplate.exchange
                ("/api/books/add/1", HttpMethod.POST, httpEntity, BookEntity.class);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }

    public void saveTest5() {
        System.out.println("Staring the Test 5");

        httpEntity = new HttpEntity<>(jsonWithoutId, httpHeaders);
        responseEntity = testRestTemplate.exchange
                ("/api/books/add", HttpMethod.POST, httpEntity, BookEntity.class);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        System.out.println(responseEntity.getBody());
        System.out.println();
    }
}
