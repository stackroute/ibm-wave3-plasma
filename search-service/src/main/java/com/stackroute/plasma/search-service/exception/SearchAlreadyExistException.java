package com.stackroute.plasma.exception;

public class SearchAlreadyExistException extends Exception{
    private String message;

    public SearchAlreadyExistException(){

    }

    public SearchAlreadyExistException(String message) {
        super();
        this.message = message;
    }
}
