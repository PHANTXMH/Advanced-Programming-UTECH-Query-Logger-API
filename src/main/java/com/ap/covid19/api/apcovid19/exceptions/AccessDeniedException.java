package com.ap.covid19.api.apcovid19.exceptions;

public class AccessDeniedException extends RuntimeException {
    private String message;
    public AccessDeniedException(String message){
        super(message);
        this.message = message;
    }
}
