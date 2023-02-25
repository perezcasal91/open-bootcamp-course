package com.perezcasal.junit.nested;

import com.perezcasal.junit.management.entity.UserEntity;
import com.perezcasal.junit.management.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NestedTest {

    static UserRepository userRepository;
    static UserEntity userToSaveSuccess;
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

    @Nested
    @EnabledIf("com.perezcasal.junit.nested.UserConditions#isUserSaved")
    public class AfterUserIsSaved {

        @BeforeAll
        static void beforeAll() {
            userRepository.saveUser(userToUpdate);
        }

        @Test
        @Order(2)
        void deleteTest() {
            boolean success = userRepository.delete(userToUpdate);

            boolean fail = userRepository.delete(userToUpdate);

            assertAll(
                    () -> assertTrue(success),
                    () -> assertFalse(fail)
            );
        }

        @Nested
        public class AfterUserIsDeleted {
            @Test
            @Order(3)
            void findAllTest() {
                List<UserEntity> list = userRepository.findAll();
                assertNotNull(list);
                assertEquals(2, list.size());
            }
        }
    }
}

class UserConditions {
    public static boolean isUserSaved() {
        UserRepository userRepository = new UserRepository();
        return userRepository
                .saveUser(new UserEntity
                        .Builder()
                        .setId(4)
                        .setName("Gina")
                        .setUsername("gina")
                        .setPassword("user")
                        .build()
                );
    }
}
