package com.bank;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users; // A map to store users with their email as the key

    // Constructor to initialize the user service
    public UserService() {
        users = new HashMap<>(); // Initialize the user map
    }

    // Method to register a new user
    public void registerUser (String name, String email, String password) {
        if (users.containsKey(email)) {
            throw new IllegalArgumentException("User  with this email already exists.");
        }
        User newUser  = new User(name, email, password); // Create a new user
        users.put(email, newUser ); // Store the user in the map
        System.out.println("User  registered successfully: " + name);
    }

    // Method to authenticate a user
    public User authenticateUser (String email, String password) {
        User user = users.get(email); // Retrieve the user by email
        if (user == null) {
            throw new IllegalArgumentException("User  not found.");
        }
        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid password.");
        }
        return user; // Return the authenticated user
    }

    // Method to get user details by email
    public User getUser ByEmail(String email) {
        User user = users.get(email); // Retrieve the user by email
        if (user == null) {
            throw new IllegalArgumentException("User  not found.");
        }
        return user; // Return the user details
    }

    // Method to display all registered users (for admin purposes)
    public void displayAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }
        System.out.println("Registered Users:");
        for (User  user : users.values()) {
            System.out.println("Name: " + user.getName() + ", Email: " + user.getEmail());
        }
    }
}
