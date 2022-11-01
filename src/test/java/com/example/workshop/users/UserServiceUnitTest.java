package com.example.workshop.users;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceUnitTest {

    @Test
    public void getById() {
        UserService userService = new UserService();
        UserResponse response = userService.getById(1);
        assertEquals(1, response.getBody().getId());
        assertEquals(200, response.getHeader().getCode());
    }

    @Test
    public void getByIdWithException() {
        UserService userService = new UserService();
        try {
            userService.getById(100);
            fail();
        }catch (UserNotFoundException e) {
            assertEquals("User id = 100 not found", e.getMessage());
        }
    }

    @Test
    public void getByIdWithException_juit5() {
        UserService userService = new UserService();
        Exception e = assertThrows(UserNotFoundException.class,
                () -> {
                    userService.getById(100);
                });
        assertEquals("User id = 100 not found", e.getMessage());
    }
}