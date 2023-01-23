package com.perezcasal.userauth.model.dto;

import com.perezcasal.userauth.model.entity.UserEntity;

public class UserEntityBuilder {

    private final UserEntity userEntity;

    public UserEntityBuilder() {
        this.userEntity = new UserEntity();
    }

    public UserEntityBuilder setUsername(String username) {
        this.userEntity.setUsername(username);
        return this;
    }

    public UserEntityBuilder setPassword(String password) {
        this.userEntity.setPassword(password);
        return this;
    }

    public UserEntityBuilder setEmail(String email) {
        this.userEntity.setEmail(email);
        return this;
    }

    public UserEntityBuilder setPhone(String phone) {
        this.userEntity.setPhone(phone);
        return this;
    }

    public UserEntityBuilder setName(String name) {
        this.userEntity.setName(name);
        return this;
    }

    public UserEntityBuilder setBusinessTitle(String businessTitle) {
        this.userEntity.setBusinessTitle(businessTitle);
        return this;
    }

    public UserEntity build() {
        return this.userEntity;
    }
}
