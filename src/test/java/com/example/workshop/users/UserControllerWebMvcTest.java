package com.example.workshop.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(UserController.class)
public class UserControllerWebMvcTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getUserById() throws Exception {
        MvcResult mvcResult =
                this.mvc.perform(get("/users/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        // Convert JSON string to Java Object
        ObjectMapper mapper = new ObjectMapper();
        byte[] data = mvcResult.getResponse().getContentAsByteArray();
        UserResponse response = mapper.readValue(data, UserResponse.class);
        // Assert
        assertEquals(200, response.getHeader().getCode());
        assertEquals(1, response.getBody().getId());
    }
}