package com.example.workshop.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable int id) {
        UserResponse response = userService.getById(id);
        return  response;
    }

    @GetMapping("/users2/{id}")
    public ResponseEntity<UserResponse> getUserById2(@PathVariable int id) {
        return new ResponseEntity<>( new UserResponse(), HttpStatus.OK);
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