package com.stackroute.userservice.exceptions;


public class UserNotFoundException extends Exception
{
    private String message1;

    public UserNotFoundException(String message1)
    {
        super(message1);
        this.message1 = message1;
    }

    public UserNotFoundException()
    {
        super();
    }
}
