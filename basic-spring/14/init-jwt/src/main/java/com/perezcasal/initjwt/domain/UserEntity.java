package com.perezcasal.initjwt.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "app_user")
@Tag(name = "App User")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "id", description = "Id",
            type = "Long", example = "1")
    private Long id;

    @Column(name = "username")
    @Schema(name = "username", description = "Username",
            type = "String", example = "elio")
    private String username;

    @Column(name = "email")
    @Schema(name = "email", description = "Email",
            type = "String", example = "elio@elio.com")
    private String email;

    @Column(name = "password")
    @Schema(name = "password", description = "Password",
            type = "String", example = "Elio2023+-")
    private String password;

    public UserEntity() {}

    public UserEntity(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity user)) return false;
        return Objects.equals(username, user.username)
                && Objects.equals(email, user.email)
                && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, password);
    }

    @Override
    public String toString() {
        return String
                .format("User[id=%d, username=%s, email=%s, password=%s",
                        id, username, email, password);
    }
}
