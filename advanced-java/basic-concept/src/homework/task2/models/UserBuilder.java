package homework.task2.models;

public class UserBuilder {
    User user;
    public UserBuilder() {
        this.user = new User();
    }
    public UserBuilder setUsername(String username) {
        user.setUsername(username);
        return this;
    }
    public UserBuilder setName(String name) {
        user.setName(name);
        return this;
    }
    public UserBuilder setLastname(String lastname) {
        user.setLastname(lastname);
        return this;
    }
    public UserBuilder setEmail(String email) {
        user.setEmail(email);
        return this;
    }
    public UserBuilder setRol(Rol rol) {
        user.setRol(rol);
        return this;
    }
    public User build() {
        return user;
    }
}
