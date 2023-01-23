package com.perezcasal.userauth.service;

import com.perezcasal.userauth.model.entity.RoleEntity;

public interface RoleService {
    RoleEntity findByName(String name);
}
