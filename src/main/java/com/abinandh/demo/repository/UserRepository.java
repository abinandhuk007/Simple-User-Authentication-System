package com.abinandh.demo.repository;

import com.abinandh.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository gives us basic CRUD methods for the User entity
public interface UserRepository extends JpaRepository<User, Long> {

    // Find a user by username (used to check duplicates)
    Optional<User> findByUsername(String username);

    // Find a user by username AND password (used for login)
    Optional<User> findByUsernameAndPassword(String username, String password);
}

