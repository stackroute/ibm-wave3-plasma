package com.stackroute.plasma.exception;

public class UserNameOrPasswordEmptyException extends Exception{

    private String message;

    public UserNameOrPasswordEmptyException()
    {}

    public UserNameOrPasswordEmptyException(String message)
    {
        this.message=message;
    }
}
