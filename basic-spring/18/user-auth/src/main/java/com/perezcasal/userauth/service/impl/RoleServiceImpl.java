package com.perezcasal.userauth.service.impl;

import com.perezcasal.userauth.model.entity.RoleEntity;
import com.perezcasal.userauth.repository.RoleRepository;
import com.perezcasal.userauth.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleEntity findByName(String name) {
        return roleRepository.findRoleByName(name);
    }
}
