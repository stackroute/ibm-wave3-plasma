package com.stackroute.userservice.exceptions;

public class UserAlreadyExistException extends Exception {
    private String message;

    public UserAlreadyExistException(String message){
        super(message);
        this.message=message;
    }
    public UserAlreadyExistException(){
        super();
    }

}
