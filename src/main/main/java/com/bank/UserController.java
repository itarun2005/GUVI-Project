package com.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users") // Base URL for user-related endpoints
public class UserController {

    @Autowired
    private UserService userService; // Injecting the UserService

    // Endpoint for user registration
    @PostMapping("/register")
    public ResponseEntity<String> registerUser (@RequestBody UserRegistrationRequest request) {
        try {
            userService.registerUser (request.getName(), request.getEmail(), request.getPassword());
            return ResponseEntity.ok("User  registered successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Endpoint for user authentication
    @PostMapping("/login")
    public ResponseEntity<String> loginUser (@RequestBody UserLoginRequest request) {
        try {
            User user = userService.authenticateUser (request.getEmail(), request.getPassword());
            return ResponseEntity.ok("User  authenticated successfully: " + user.getName());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Additional endpoints can be added here
}
