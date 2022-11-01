package com.example.workshop.todos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyTodoGatewayTest {

    @Autowired
    private MyTodoGateway gateway;

    @Test
    public void getById() {
        // Act
        TodoResponse result = gateway.getById(1);
        //Assert
        assertEquals(1, result.getId());
        assertEquals("delectus aut autem", result.getTitle());
    }
}