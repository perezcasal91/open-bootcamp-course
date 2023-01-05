package com.perezcasal.initspring.controllers;

import com.perezcasal.initspring.entities.LaptopEntity;
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
class LaptopsControllerTest {
    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;
    private ResponseEntity<LaptopEntity> responseEntity;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void saveTest() {
        SaveLaptopControllerTest saveLaptopControllerTest = new SaveLaptopControllerTest(testRestTemplate);
        saveLaptopControllerTest.saveTest1();
        saveLaptopControllerTest.saveTest2();
        saveLaptopControllerTest.saveTest3();
    }

    @Test
    void updateTest() {
        UpdateLaptopControllerTest updateLaptopControllerTest = new UpdateLaptopControllerTest(testRestTemplate);
        updateLaptopControllerTest.updateTest1();
        updateLaptopControllerTest.updateTest2();
    }

    @Test
    void deleteTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Delete laptop.");

        testRestTemplate.delete("/api/laptops/3", LaptopEntity.class);

        responseEntity = testRestTemplate.getForEntity("/api/laptops/1", LaptopEntity.class);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void deleteAllTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Delete all laptops.");

        testRestTemplate.delete("/api/laptops", LaptopEntity.class);

        ResponseEntity<LaptopEntity[]> responseListOfEntity = testRestTemplate.getForEntity("/api/laptops", LaptopEntity[].class);
        var laptopEntityList = List.of(Objects.requireNonNull(responseListOfEntity.getBody()));

        assertEquals(HttpStatus.OK, responseListOfEntity.getStatusCode());
        assertEquals(0, laptopEntityList.size());
        System.out.println();
    }

    @Test
    void getTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Laptop found.");
        save();

        responseEntity = testRestTemplate.getForEntity("/api/laptops/4", LaptopEntity.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(4, Objects.requireNonNull(responseEntity.getBody()).getId());
        assertEquals("HP", Objects.requireNonNull(responseEntity.getBody()).getBrand());
        assertEquals("HDD", Objects.requireNonNull(responseEntity.getBody()).getStorage());
        assertEquals(2.5, Objects.requireNonNull(responseEntity.getBody()).getPrice());
        assertEquals(LocalDate.of(2023, 1, 3),
                Objects.requireNonNull(responseEntity.getBody()).getReleaseDate());
        assertEquals(false, Objects.requireNonNull(responseEntity.getBody()).getWifi());

        System.out.println(responseEntity.getBody());
        System.out.println();

        System.out.println("Staring the Test 2: Laptop not found.");
        responseEntity = testRestTemplate.getForEntity("/api/laptops/2", LaptopEntity.class);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void getAllTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Get all the laptops");

        ResponseEntity<LaptopEntity[]> responseListOfEntity = testRestTemplate.getForEntity("/api/laptops", LaptopEntity[].class);
        var laptopEntityList = List.of(Objects.requireNonNull(responseListOfEntity.getBody()));

        assertEquals(HttpStatus.OK, responseListOfEntity.getStatusCode());
        assertEquals(2, laptopEntityList.size());

        laptopEntityList.forEach(System.out::println);
        System.out.println();
    }

    private void save() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
       String json = """
                {
                    "brand": "HP",
                    "storage": "HDD",
                    "price": 2.5,
                    "releaseDate": "2023-01-03",
                    "wifi": false
                }
                """;
        HttpEntity<String> httpEntity = new HttpEntity<>(json, httpHeaders);
        responseEntity = testRestTemplate.exchange("/api/laptops/add", HttpMethod.POST, httpEntity, LaptopEntity.class);
    }
}