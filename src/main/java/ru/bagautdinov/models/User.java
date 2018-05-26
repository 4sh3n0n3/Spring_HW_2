package ru.bagautdinov.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import ru.bagautdinov.models.enums.UserRoles;

import java.util.Collection;

@Entity
@SequenceGenerator(name = "user_gen", sequenceName = "users_seq", allocationSize = 1)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    private long id;

    @NotNull(message="Пожалуйста, введите пароль")
    private String password;

    @NotNull(message="Пожалуйста, введите ваш email")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Введите ваш логин")
    @Column(unique = true)
    private String username;

    @Enumerated(EnumType.STRING)
    private UserRoles role;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRoles getRole() {
        return role;
    }
    public void setRole(UserRoles role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return this.email + " : " + super.toString();
    }
}
