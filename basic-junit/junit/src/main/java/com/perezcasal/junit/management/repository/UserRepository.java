package com.perezcasal.junit.management.repository;

import com.perezcasal.junit.management.database.UserDB;
import com.perezcasal.junit.management.entity.UserEntity;

import java.util.List;
import java.util.NoSuchElementException;

public class UserRepository {
    private final UserDB userDB;

    public UserRepository() {
        this.userDB = UserDB.openConnection();
    }

    public boolean saveUser(UserEntity userToSave) {
        if (userToSave == null) {
            throw new NullPointerException("Failed to save, user can not be null.");
        }
        if (existsById(userToSave.getId())) {
            throw new NoSuchElementException("Failed to save, user already exists with this id: "
                    + userToSave.getId() + " .");
        }
        if (existsByUsername(userToSave.getUsername())) {
            throw new NoSuchElementException("Failed to save, user already exists with this username: "
                    + userToSave.getUsername() + " .");
        }
        return userDB.save(userToSave);
    }

    public List<UserEntity> findAll() {
        return userDB.findAll().stream().map(o -> (UserEntity) o).toList();
    }

    public UserEntity updateUser(UserEntity userToSave, UserEntity userToUpdate) {
        if (userToSave == null) {
            throw new NullPointerException("Failed to update, user can not be null.");
        }
        if (userToUpdate == null) {
            throw new NullPointerException("Failed to update, user can not be null.");
        }
        int index = findAll().indexOf(userToSave);
        if (index == -1) {
            throw new NoSuchElementException("Failed to update, user not found.");
        }
        return (UserEntity) userDB.update(index, userToUpdate);
    }

    public UserEntity findById(Long id) {
        return findAll().stream()
                .filter(userEntity -> userEntity.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public UserEntity findByUsername(String username) {
        return findAll().stream()
                .filter(userEntity -> userEntity.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public boolean delete(UserEntity userToUpdate) {
        return userDB.delete(userToUpdate);
    }


    public boolean existsById(Long id) {
        return findAll().stream().anyMatch(userEntity -> userEntity.getId().equals(id));
    }

    public boolean existsByUsername(String username) {
        return findAll().stream().anyMatch(userEntity -> userEntity.getUsername().equals(username));
    }
}
