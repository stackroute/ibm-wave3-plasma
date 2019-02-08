package com.stackroute.nextevent.controller;

import com.stackroute.nextevent.exception.EventAlreadyExist;
import com.stackroute.nextevent.exception.EventNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalExceptionHandler {
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Event Already Exists")
    @ExceptionHandler(EventAlreadyExist.class)
    public void handleEventAlreadyExists(EventAlreadyExist e) {
        log.error("Event alredy Exists");
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Event Not Found")
    @ExceptionHandler(EventNotFound.class)
    public void handleEventNotFound() {
        log.error("Event Not Found");
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Something went wrong ")
    public void handleException(Exception e) {
        log.error("Try!!! After sometime");
    }

}
