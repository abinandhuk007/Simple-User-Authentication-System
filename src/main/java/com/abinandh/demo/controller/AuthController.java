package com.abinandh.demo.controller;

import com.abinandh.demo.model.User;
import com.abinandh.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// REST controller to handle signup, login and delete-all-users operations
@RestController
@RequestMapping("/api")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Helper method to create a simple JSON response
    private Map<String, Object> response(boolean success, String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", success);
        map.put("message", message);
        return map;
    }

    // SIGNUP endpoint: POST /api/signup
    @PostMapping("/signup")
    public Map<String, Object> signup(@RequestBody User requestUser) {
        Optional<User> existing = userRepository.findByUsername(requestUser.getUsername());
        if (existing.isPresent()) {
            return response(false, "Username already exists. Please choose another one.");
        }

        User newUser = new User(requestUser.getUsername(), requestUser.getPassword());
        userRepository.save(newUser);

        return response(true, "User registered successfully.");
    }

    // LOGIN endpoint: POST /api/login
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User requestUser) {
        Optional<User> user = userRepository.findByUsernameAndPassword(
                requestUser.getUsername(),
                requestUser.getPassword()
        );

        if (user.isPresent()) {
            return response(true, "Login successful.");
        } else {
            return response(false, "Invalid username or password.");
        }
    }

    // DELETE ALL USERS endpoint: DELETE /api/users
    @DeleteMapping("/users")
    public Map<String, Object> deleteAllUsers() {
        userRepository.deleteAll();
        return response(true, "All users have been deleted.");
    }
}

