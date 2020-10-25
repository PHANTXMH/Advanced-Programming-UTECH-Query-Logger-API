package com.ap.covid19.api.apcovid19.exceptions;

public class ComplaintNotFoundException extends RuntimeException {
    private String message;
    public ComplaintNotFoundException(String message){
        super(message);
        this.message = message;
    }
}
