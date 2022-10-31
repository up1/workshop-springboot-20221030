package com.example.workshop.users;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    @DisplayName("การทดสอบดึงข้อมูลผู้ใช้งาน ....")
    public void success_case() {
        // Act
        UserResponse response
                = template.getForObject("/users/1", UserResponse.class);
        // Assert
        assertEquals(200, response.getHeader().getCode());
        assertEquals(1, response.getBody().getId());
    }
}