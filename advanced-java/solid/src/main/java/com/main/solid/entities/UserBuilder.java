package com.main.solid.entities;

public class UserBuilder {
    private final User user;
    public UserBuilder() {
        user = new User();
    }
    public UserBuilder setUsername(String username) {
        user.setUsername(username);
        return this;
    }
    public UserBuilder setName(String name) {
        user.setName(name.length() > 0 ? name : "none name");
        return this;
    }
    public UserBuilder setLastname(String lastname) {
        user.setLastname(lastname.length() > 0 ? lastname : "none lastname");
        return this;
    }
    public UserBuilder setEmail(String email) {
        user.setEmail(email.length() > 0 ? email : "none email");
        return this;
    }
    public UserBuilder setAccessLevel(int accessLevel) {
        user.setAccessLevel(accessLevel);
        return this;
    }
    public User build() {
        return user;
    }
}
