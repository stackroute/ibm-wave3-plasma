//package com.stackroute.userservice.exceptions;
//
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@ControllerAdvice
//
//public class GloballyExceptionHandler {
//    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Not all mandatory fields are filled-reason")
//    @ExceptionHandler(UserNotFoundException.class)
//    public void handleUpdateException(UserNotFoundException e){
//
//    }    @ResponseStatus(value= HttpStatus.CONFLICT, reason="User already exists-reason")
//    @ExceptionHandler(UserAlreadyExistException.class)
//    public void handleUserAlreadyExistsException(UserAlreadyExistException e){
//
//    }
//
//}
