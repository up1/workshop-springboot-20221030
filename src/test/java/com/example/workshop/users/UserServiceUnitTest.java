package com.example.workshop.users;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceUnitTest {

    @Test
    public void getById() {
        UserService userService = new UserService();
        UserResponse response = userService.getById(1);
        assertEquals(1, response.getBody().getId());
        assertEquals(200, response.getHeader().getCode());
    }
}