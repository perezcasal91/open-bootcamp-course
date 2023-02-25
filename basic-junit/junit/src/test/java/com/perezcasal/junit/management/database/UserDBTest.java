package com.perezcasal.junit.management.database;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDBTest {
    static UserDB userDB;
    static Object o1;
    static Object o2;

    static Object o3;

    @BeforeAll
    static void beforeAll() {
        userDB = UserDB.openConnection();
        o1 = new Object();
        o2 = new Object();
        o3 = new Object();
    }

    @AfterAll
    static void afterAll() {
        UserDB.closeConnection();
    }

    @Test
    @Order(1)
    @DisplayName("Save: Success Scenario -> Saved True.")
    void saveTest1() {
        boolean saved = userDB.save(o1);
        assertTrue(saved);
    }

    @Test
    @Order(2)
    @DisplayName("Find All: Success Scenario -> Database with 2 Objects")
    void findAllTest() {
        List<Object> list = userDB.findAll();
        assertEquals(1, list.size());
    }

    @Test
    @Order(3)
    @DisplayName("Save: Success Scenario -> Database with more than one Object.")
    void saveTest2() {
        userDB.save(o2);
        List<Object> list = userDB.findAll();
        assertEquals(2, list.size());
    }

    @Test
    @Order(4)
    @DisplayName("Update: Success Scenario -> Result no null.")
    void updateTest() {
        Object result = userDB.update(0, o3);
        assertNotNull(result);
    }

    @Test
    @Order(5)
    @DisplayName("Delete: Success Scenario -> Delete True.")
    void deleteTest() {
        boolean deleted = userDB.delete(o2);
        assertTrue(deleted);
    }


}
