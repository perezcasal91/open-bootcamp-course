package com.perezcasal.junit.db_simulator;

public class User {
    private String username;
    private String name;
    private String lastname;
    private String email;
    private int accessLevel;

    public User() {
        this.name = "";
        this.lastname = "";
        this.email = "";
        this.accessLevel = 0;
    }

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

    public static class Builder {
        private final User user;

        public Builder() {
            user = new User();
        }

        public Builder setUsername(String username) {
            user.setUsername(username);
            return this;
        }

        public Builder setName(String name) {
            user.setName(name.length() > 0 ? name : "none name");
            return this;
        }

        public Builder setLastname(String lastname) {
            user.setLastname(lastname.length() > 0 ? lastname : "none lastname");
            return this;
        }

        public Builder setEmail(String email) {
            user.setEmail(email.length() > 0 ? email : "none email");
            return this;
        }

        public Builder setAccessLevel(int accessLevel) {
            user.setAccessLevel(accessLevel);
            return this;
        }

        public User build() {
            return user;
        }
    }
}
