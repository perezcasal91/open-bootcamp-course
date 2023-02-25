package com.perezcasal.designpatterns.patterns.creational.builder;

public class UserBuilderMain {
    public static void main(String[] args) {
        User user = new User.Builder().setId(1).build();
        System.out.println(user.getId());
        User builder = new User.Builder().setId(2).setName("Elio").setLastname("Perez").build();
        System.out.println(builder.getId() + " " + builder.getName() + " " + builder.getLastname());
    }
}

class User {
    private Integer id;
    private String name, lastname, username, password, email;
    private Boolean signIn, logOut;

    public User() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getSignIn() {
        return signIn;
    }

    public void setSignIn(Boolean signIn) {
        this.signIn = signIn;
    }

    public Boolean getLogOut() {
        return logOut;
    }

    public void setLogOut(Boolean logOut) {
        this.logOut = logOut;
    }

    public static class Builder {
        private final User user;

        public Builder() {
            this.user = new User();
        }

        public Builder setId(Integer id) {
            this.user.setId(id);
            return this;
        }

        public Builder setName(String name) {
            this.user.setName(name);
            return this;
        }

        public Builder setLastname(String lastname) {
            this.user.setLastname(lastname);
            return this;
        }

        public Builder setUsername(String username) {
            this.user.setUsername(username);
            return this;
        }

        public Builder setPassword(String password) {
            this.user.setPassword(password);
            return this;
        }

        public Builder setEmail(String email) {
            this.user.setEmail(email);
            return this;
        }

        public Builder setSignIn(Boolean signIn) {
            this.user.setSignIn(signIn);
            return this;
        }

        public Builder setLogOut(Boolean logOut) {
            this.user.setLogOut(logOut);
            return this;
        }
        public User build() {
            return this.user;
        }
    }
}