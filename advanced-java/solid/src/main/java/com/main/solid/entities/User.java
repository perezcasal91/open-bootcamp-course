package com.main.solid.entities;

public class User {
    private String username;
    private String name;
    private String lastname;
    private String email;
    private int accessLevel;
    public User() {}
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAccessLevel() {
        return accessLevel;
    }
    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
    @Override
    public String toString() {
        return "User{ "
                + "username:" + getUsername()
                + ",name:" + getName()
                + ",lastname:" + getLastname()
                + ",email:" + getEmail()
                + ",access-level:" + getAccessLevel()
                + " }";
    }
}
