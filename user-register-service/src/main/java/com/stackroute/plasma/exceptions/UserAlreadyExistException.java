package com.stackroute.plasma.exceptions;

public class UserAlreadyExistException extends Exception {
    private String message;
    public UserAlreadyExistException(){}

    public UserAlreadyExistException(String message){
        super(message);
        this.message=message;
    }
}
