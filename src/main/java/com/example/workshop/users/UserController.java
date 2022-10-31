package com.example.workshop.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable int id) {
        if(id <= 10) {
            Header header = new Header(200, "ok");
            Body body = new Body(id);
            UserResponse response = new UserResponse();
            response.setHeader(header);
            response.setBody(body);
            return response;
        }
        return new UserResponse();
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