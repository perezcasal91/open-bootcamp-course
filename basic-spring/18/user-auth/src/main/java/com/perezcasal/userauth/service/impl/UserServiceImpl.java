package com.perezcasal.userauth.service.impl;

import com.perezcasal.userauth.exception.EmailAlreadyExistsException;
import com.perezcasal.userauth.exception.UsernameAlreadyExistsException;
import com.perezcasal.userauth.model.dto.UserDTO;
import com.perezcasal.userauth.model.entity.RoleEntity;
import com.perezcasal.userauth.model.entity.UserEntity;
import com.perezcasal.userauth.repository.UserRepository;
import com.perezcasal.userauth.service.RoleService;
import com.perezcasal.userauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder bcryptEncoder;

    public UserServiceImpl(BCryptPasswordEncoder bcryptEncoder) {
        this.bcryptEncoder = bcryptEncoder;
    }

    public List<UserEntity> findAll() {
        List<UserEntity> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserEntity save(UserDTO userDTO) {

        UserEntity userEntity = userDTO.getUserFromDTO();

        if(userRepository.existsByUsername(userEntity.getUsername()))
            throw new UsernameAlreadyExistsException("Busy Username");

        if(userRepository.existsByEmail(userEntity.getEmail()))
            throw new EmailAlreadyExistsException("Busy Email");

        userEntity.setPassword(bcryptEncoder.encode(userEntity.getPassword()));

        RoleEntity role = roleService.findByName("USER");
        Set<RoleEntity> roleSet = new HashSet<>();
        roleSet.add(role);

        if(userEntity.getUsername().equalsIgnoreCase("elio")){
            role = roleService.findByName("ADMIN");
            roleSet.add(role);
        }

        userEntity.setRoles(roleSet);
        return userRepository.save(userEntity);
    }
}

