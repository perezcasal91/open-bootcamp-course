package com.perezcasal.userauth.model.dto;

import com.perezcasal.userauth.model.entity.UserEntity;

public class UserDTO {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String name;
    private String businessTitle;

    public UserDTO() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessTitle() {
        return businessTitle;
    }

    public void setBusinessTitle(String businessTitle) {
        this.businessTitle = businessTitle;
    }

    public UserEntity getUserFromDTO() {
        return new UserEntityBuilder()
                .setUsername(getUsername())
                .setPassword(getPassword())
                .setEmail(getEmail())
                .setPhone(getPhone())
                .setName(getName())
                .setBusinessTitle(getBusinessTitle())
                .build();
    }
}
