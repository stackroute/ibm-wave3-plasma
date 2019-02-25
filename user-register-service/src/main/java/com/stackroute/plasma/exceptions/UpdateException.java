package com.stackroute.plasma.exceptions;

public class UpdateException extends Exception {
    private String message;

    public UpdateException(){
        super();
    }

    public UpdateException(String message){
        super(message);
        this.message=message;
    }
}
