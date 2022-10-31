package com.example.workshop.users;

public class UserNotFoundException extends RuntimeException {
    private int id;
    public UserNotFoundException(String s, int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
