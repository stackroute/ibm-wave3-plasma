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
        @ResponseStatus(value= HttpStatus.CONFLICT, reason="UserAuth Id and Password are not matching")
        @ExceptionHandler(UserIdAndPasswordMismatchException.class)
        public void handleUserIdAndPasswordMismatchException(UserIdAndPasswordMismatchException e){
            // log.error("UserAuth already exists", e);
        }

        @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="UserAuth does not exist")
        @ExceptionHandler(UserNotFoundException.class)
        public void handleUserNotFoundException(UserNotFoundException e){
            // log.error("UserAuth does not exist", e);
        }
        @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="UserAuth Name or Password Empty")
        @ExceptionHandler(UserNameOrPasswordEmptyException.class)
        public void handleUserNameOrPasswordEmptyException(UserNameOrPasswordEmptyException e){
            // log.error("UserAuth does not exist", e);
        }
    }

