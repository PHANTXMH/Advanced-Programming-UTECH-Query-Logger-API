package com.ap.covid19.api.apcovid19.exceptions;

public class UserNotFoundException extends RuntimeException {
    private String message;
    public UserNotFoundException(String message){
        super(message);
        this.message = message;
    }
}
