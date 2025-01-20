package com.bank;

public class User {
    private String name; // Name of the user
    private String email; // Email of the user
    private String password; // Password of the user

    // Constructor to initialize a new user
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password; // In a real application, consider hashing the password
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password; // In a real application, do not expose the password
    }
}
