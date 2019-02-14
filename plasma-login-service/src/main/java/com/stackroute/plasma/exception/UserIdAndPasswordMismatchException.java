package com.stackroute.plasma.exception;

public class UserIdAndPasswordMismatchException extends Throwable {
    private String message;

    public String getMessage() {
        return message;
    }

    public UserIdAndPasswordMismatchException(){}

    public UserIdAndPasswordMismatchException(String message) {
        this.message = message;
    }
}
