package com.perezcasal.userauth.service;

import com.perezcasal.userauth.model.dto.UserDTO;
import com.perezcasal.userauth.model.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity save(UserDTO userDTO);
    List<UserEntity> findAll();
    UserEntity findByUsername(String username);
}
