package com.stackroute.plasma.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Not all mandatory fields are filled-reason")
    @ExceptionHandler(UpdateException.class)
    public void handleUpdateException(UpdateException e){

    }

    @ResponseStatus(value= HttpStatus.CONFLICT, reason="User already exists-reason")
    @ExceptionHandler(UserAlreadyExistException.class)
    public void handleUserAlreadyExistsException(UserAlreadyExistException e){

    }

}
