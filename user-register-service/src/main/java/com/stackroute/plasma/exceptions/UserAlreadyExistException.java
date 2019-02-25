package com.stackroute.plasma.exceptions;

public class UserAlreadyExistException extends Exception {
    private String message;

    public UserAlreadyExistException(){
        super();
    }

    public UserAlreadyExistException(String message){
        super(message);
        this.message=message;
    }
}
