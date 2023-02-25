package com.perezcasal.junit.management.entity;

public class UserEntity {

    private Long id;
    private String name, username, password;

    public UserEntity() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                '}';
    }

    public static class Builder {
        private final UserEntity userEntity;

        public Builder() {
            userEntity = new UserEntity();
        }

        public Builder setId(long id) {
            userEntity.setId(id);
            return this;
        }

        public Builder setName(String name) {
            userEntity.setName(name);
            return this;
        }

        public Builder setUsername(String username) {
            userEntity.setUsername(username);
            return this;
        }

        public Builder setPassword(String password) {
            userEntity.setPassword(password);
            return this;
        }

        public UserEntity build() {
            return userEntity;
        }
    }
}
