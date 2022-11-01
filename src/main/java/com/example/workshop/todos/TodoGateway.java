package com.example.workshop.todos;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class TodoGateway {

    private RestTemplate restTemplate;

    public TodoGateway(RestTemplateBuilder builder){
        restTemplate = builder.build();
    }

    public Optional<TodoResponse> getById(int id) {
        String url = String.format("https://jsonplaceholder.typicode.com/todos/%d", id);
        try {
            TodoResponse result = restTemplate.getForObject(url,
                    TodoResponse.class);
            return Optional.of(result);
        }catch (Exception e) {
            return Optional.empty();
        }
    }
}
