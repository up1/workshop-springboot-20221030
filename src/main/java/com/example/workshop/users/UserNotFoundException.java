package com.example.workshop.users;

public class UserNotFoundException extends RuntimeException {
    private int id;
    public UserNotFoundException(String s, int id) {
        super(s);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
