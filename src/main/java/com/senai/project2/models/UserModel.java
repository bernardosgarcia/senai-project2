package com.senai.project2.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="usr_id")
    private Integer id;

    @Column(name="usr_login")
    private String login;

    @Column(name="usr_password")
    private String password;

    @Column(name="usr_email")
    private String email;

    @Column(name="usr_created_at")
    private LocalDate createdAt;

    @Column(name = "usr_updated_at")
    private LocalDate updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
