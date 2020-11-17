package com.ap.covid19.api.apcovid19.exceptions;

public class ComplaintResponseNotFoundException extends RuntimeException {
    private String message;
    public ComplaintResponseNotFoundException(String message){
        super(message);
        this.message = message;
    }
}
