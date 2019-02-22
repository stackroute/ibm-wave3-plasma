package com.stackroute.plasma.exception;

public class UserNotFoundException extends Exception {
    private String message;

    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        this.message = message;

    }
}