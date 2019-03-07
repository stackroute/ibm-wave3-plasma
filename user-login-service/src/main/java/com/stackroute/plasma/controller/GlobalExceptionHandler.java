package com.stackroute.plasma.controller;

import com.stackroute.plasma.exception.UserIdAndPasswordMismatchException;
import com.stackroute.plasma.exception.UserNameOrPasswordEmptyException;
import com.stackroute.plasma.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


    @ControllerAdvice
    public class GlobalExceptionHandler {
        @ResponseStatus(value= HttpStatus.CONFLICT, reason="User Id and Password are not matching")
        @ExceptionHandler(UserIdAndPasswordMismatchException.class)
        public void handleUserIdAndPasswordMismatchException(UserIdAndPasswordMismatchException e){
         }

        @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="User does not exist")
        @ExceptionHandler(UserNotFoundException.class)
        public void handleUserNotFoundException(UserNotFoundException e){
         }
        @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="User Name or Password Empty")
        @ExceptionHandler(UserNameOrPasswordEmptyException.class)
        public void handleUserNameOrPasswordEmptyException(UserNameOrPasswordEmptyException e){
         }
    }

