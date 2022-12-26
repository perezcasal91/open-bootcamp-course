package homework.task2.models;

public class User {
    private String username;
    private String name;
    private String lastname;
    private String email;
    private Rol rol;
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
    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    @Override
    public String toString() {
        return "User { " +
                " username=" + getUsername() +
                ", name=" + getName() +
                ", lastname=" + getLastname() +
                ", email=" + getEmail() +
                ", rol=" + getRol() +
                " } ";
    }
}
