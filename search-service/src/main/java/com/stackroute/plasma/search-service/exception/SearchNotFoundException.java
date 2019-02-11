package com.stackroute.plasma.exception;

public class SearchNotFoundException extends Exception {
    private String msg;

    public SearchNotFoundException() {
    }

    public SearchNotFoundException(String msg) {
        super();
        this.msg = msg;
    }
}
