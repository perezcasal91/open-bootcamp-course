package com.perezcasal.junit.management.repository;

import com.perezcasal.junit.management.entity.UserEntity;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest {

    static UserRepository userRepository;
    static UserEntity userToSaveSuccess;
    static UserEntity userToSaveFail;
    static UserEntity userToUpdate;

    @BeforeAll
    static void beforeAll() {
        userRepository = new UserRepository();

        userToSaveSuccess = new UserEntity
                .Builder()
                .setId(1L)
                .setName("Elio")
                .setUsername("elio")
                .setPassword("admin")
                .build();

        userToSaveFail = new UserEntity
                .Builder()
                .setId(2L)
                .setName("Elio")
                .setUsername("elio")
                .setPassword("admin")
                .build();

        userToUpdate = new UserEntity
                .Builder()
                .setId(3L)
                .setName("Day")
                .setUsername("day")
                .setPassword("user")
                .build();
    }

    @Test
    @Order(1)
    void saveTest1() {
        boolean saved = userRepository.saveUser(userToSaveSuccess);
        assertTrue(saved);
    }

    @Test
    @Order(2)
    void findAllTest() {
        List<UserEntity> list = userRepository.findAll();
        assertNotNull(list);
        assertEquals(1, list.size());
    }

    @Test
    @Order(3)
    void existsByIdTest() {
        boolean success = userRepository.existsById(userToSaveSuccess.getId());

        boolean fail = userRepository.existsById(userToSaveFail.getId());

        assertAll(
                () -> assertTrue(success),
                () -> assertFalse(fail)
        );
    }

    @Test
    @Order(4)
    void existsByUsernameTest() {
        boolean success = userRepository.existsByUsername(userToSaveSuccess.getUsername());

        boolean fail = userRepository.existsByUsername(userToUpdate.getUsername());

        assertAll(
                () -> assertTrue(success),
                () -> assertFalse(fail)
        );
    }

    @Test
    @Order(5)
    void saveTest2() {
        Exception nullUser = assertThrows(NullPointerException.class,
                () -> userRepository.saveUser(null));

        Exception existId = assertThrows(NoSuchElementException.class,
                () -> userRepository.saveUser(userToSaveSuccess));

        Exception existUsername = assertThrows(NoSuchElementException.class,
                () -> userRepository.saveUser(userToSaveFail));

        assertAll(
                () -> assertEquals("Failed to save, user can not be null.", nullUser.getMessage()),
                () -> assertEquals("Failed to save, user already exists with this id: "
                        + userToSaveSuccess.getId() + " .", existId.getMessage()),
                () -> assertEquals("Failed to save, user already exists with this username: "
                        + userToSaveFail.getUsername() + " .", existUsername.getMessage())
        );
    }

    @Test
    @Order(6)
    void updateTest1() {
        UserEntity updated = userRepository.updateUser(userToSaveSuccess, userToUpdate);
        assertNotNull(updated);
    }

    @Test
    @Order(7)
    void updateTest2() {
        Exception nullUserToSave = assertThrows(NullPointerException.class,
                () -> userRepository.updateUser(null, userToUpdate));

        Exception nullUserToUpdate = assertThrows(NullPointerException.class,
                () -> userRepository.updateUser(userToSaveSuccess, null));

        Exception notFound = assertThrows(NoSuchElementException.class,
                () -> userRepository.updateUser(userToSaveFail, userToUpdate));

        assertAll(
                () -> assertEquals("Failed to update, user can not be null.", nullUserToSave.getMessage()),
                () -> assertEquals("Failed to update, user can not be null.", nullUserToUpdate.getMessage()),
                () -> assertEquals("Failed to update, user not found.", notFound.getMessage())
        );
    }

    @Test
    @Order(8)
    void findById() {
        UserEntity found = userRepository.findById(userToUpdate.getId());

        UserEntity notFound = userRepository.findById(userToSaveFail.getId());

        assertAll(
                () -> assertNotNull(found),
                () -> assertNull(notFound)
        );
    }

    @Test
    @Order(9)
    void findByUsername() {
        UserEntity found = userRepository.findByUsername(userToUpdate.getUsername());

        UserEntity notFound = userRepository.findByUsername(userToSaveFail.getUsername());

        assertAll(
                () -> assertNotNull(found),
                () -> assertNull(notFound)
        );
    }

    @Test
    @Order(10)
    void deleteTest() {
        boolean success = userRepository.delete(userToUpdate);

        boolean fail = userRepository.delete(userToSaveFail);

        assertAll(
                () -> assertTrue(success),
                () -> assertFalse(fail)
        );
    }
}
