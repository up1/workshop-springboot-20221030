package com.example.workshop.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<UserResponse> userNotFound(UserNotFoundException e) {
        Header header = new Header(404, "ok");
        Body body = new Body(e.getId());
        UserResponse response = new UserResponse();
        response.setHeader(header);
        response.setBody(body);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @ExceptionHandler(BusinessException.class)
//    public ResponseEntity<UserResponse> xx(BusinessException e) {
//        Header header = new Header(404, "ok");
//        Body body = new Body(e.getId());
//        UserResponse response = new UserResponse();
//        response.setHeader(header);
//        response.setBody(body);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }



}
