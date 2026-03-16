package com.abinandh.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Simple User entity mapped to the "users" table in PostgreSQL
@Entity
@Table(name = "users")
public class User {

    // Primary key column (id)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Username column (unique so same username cannot be used twice)
    @Column(nullable = false, unique = true)
    private String username;

    // Password column (in real apps, you should hash this!)
    @Column(nullable = false)
    private String password;

    // Default constructor is required by JPA
    public User() {
    }

    // Convenience constructor (optional)
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

