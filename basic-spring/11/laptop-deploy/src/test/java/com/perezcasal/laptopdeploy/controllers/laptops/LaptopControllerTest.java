package com.perezcasal.laptopdeploy.controllers.laptops;

import com.perezcasal.laptopdeploy.entities.LaptopEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
class LaptopControllerTest {
    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;
    private ResponseEntity<LaptopEntity> responseEntity;
    @Value(value = "${app.environment}")
    private String environment;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void saveTest() {
        LControllerSaveTest lControllerSaveTest = new LControllerSaveTest(testRestTemplate, environment);
        lControllerSaveTest.saveTest1();
        lControllerSaveTest.saveTest2();
        lControllerSaveTest.saveTest3();
        lControllerSaveTest.saveTest4();
        lControllerSaveTest.saveTest5();
    }

    @Test
    void updateTest() {
        LControllerUpdateTest lControllerUpdateTest = new LControllerUpdateTest(testRestTemplate, environment);
        lControllerUpdateTest.updateTest1();
        lControllerUpdateTest.updateTest2();
        lControllerUpdateTest.updateTest3();
        lControllerUpdateTest.updateTest4();
        lControllerUpdateTest.updateTest5();
    }

    @Test
    void deleteTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Delete laptop.");

        testRestTemplate.delete("/api/" + environment + "/laptops/3", LaptopEntity.class);

        responseEntity = testRestTemplate
                .getForEntity("/api/" + environment + "/laptops/3", LaptopEntity.class);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void deleteAllTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Delete all laptops.");

        testRestTemplate.delete("/api/" + environment + "/laptops", LaptopEntity.class);

        var responseListOfEntity = testRestTemplate
                .getForEntity("/api/" + environment + "/laptops", LaptopEntity[].class);
        var laptopsList = List.of(Objects.requireNonNull(responseListOfEntity.getBody()));

        assertEquals(HttpStatus.OK, responseListOfEntity.getStatusCode());
        assertEquals(0, laptopsList.size());
        System.out.println();
    }

    @Test
    void getTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Laptop found.");
        save();

        responseEntity = testRestTemplate
                .getForEntity("/api/" + environment + "/laptops/4", LaptopEntity.class);

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
        responseEntity = testRestTemplate
                .getForEntity("/api/" + environment + "/laptops/2", LaptopEntity.class);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void getAllTest() {
        System.out.println();
        System.out.println("Staring the Test 1: Get all the laptops.");

        var responseListOfEntity = testRestTemplate
                .getForEntity("/api/" + environment + "/laptops", LaptopEntity[].class);
        var laptopsList = List.of(Objects.requireNonNull(responseListOfEntity.getBody()));

        assertEquals(HttpStatus.OK, responseListOfEntity.getStatusCode());
        assertEquals(2, laptopsList.size());

        laptopsList.forEach(System.out::println);
        System.out.println();
    }

    private void save() {
        var httpHeaders = new HttpHeaders();
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
        var httpEntity = new HttpEntity<>(json, httpHeaders);
        responseEntity = testRestTemplate
                .exchange("/api/" + environment + "/laptops/add"
                        , HttpMethod.POST, httpEntity, LaptopEntity.class);
    }
}