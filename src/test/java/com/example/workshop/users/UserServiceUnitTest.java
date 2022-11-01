package com.example.workshop.users;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceUnitTest {

    @Mock
    private UserRepository userRepository;

    @Test
    public void getById() {
        //Arrange
        UserService userService = new UserService();
        userService.setUserRepository(userRepository);
        // Act
        UserResponse response = userService.getById(1);
        // Assert
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