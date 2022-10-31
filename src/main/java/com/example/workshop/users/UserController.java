package com.example.workshop.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable int id) {
        return new UserResponse();
    }

}
/**

 GET /users/<id>

 {
 "header": {
     "code": 200,
     "message": "OK"
 },
 "body": {
     "id": 1,
     "firstname": "somkiat",
     "lastname": "pui"
 }
 }

 */