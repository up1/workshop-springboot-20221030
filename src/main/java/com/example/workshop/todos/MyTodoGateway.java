package com.example.workshop.todos;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "jsonplaceholder", url = "https://jsonplaceholder.typicode.com")
public interface MyTodoGateway {

    @GetMapping("/todos/{id}")
    TodoResponse getById(@PathVariable int id);

}
