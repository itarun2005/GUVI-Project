package com.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    public void testRegisterUser () {
        userService.registerUser ("John Doe", "john@example.com", "password123");
        User user = userService.getUser ByEmail("john@example.com");
        assertEquals("John Doe", user.getName());
    }

    @Test
    public void testRegisterDuplicateUser () {
        userService.registerUser ("John Doe", "john@example.com", "password123");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.registerUser ("John Doe", "john@example.com", "password456");
        });
        assertEquals("User  with this email already exists.", exception.getMessage());
    }

    @Test
    public void testAuthenticateUser () {
        userService.registerUser ("John Doe", "john@example.com", "password123");
        User user = userService.authenticateUser ("john@example.com", "password123");
        assertEquals("John Doe", user.getName());
    }

    @Test
    public void testAuthenticateInvalidUser () {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.authenticateUser ("nonexistent@example.com", "password123");
        });
        assertEquals("User  not found.", exception.getMessage());
    }

    @Test
    public void testAuthenticateInvalidPassword() {
        userService.registerUser ("John Doe", "john@example.com", "password123");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.authenticateUser ("john@example.com", "wrongpassword");
        });
        assertEquals("Invalid password.", exception.getMessage());
    }
}
