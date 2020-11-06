package com.ap.covid19.api.apcovid19.exceptions;

public class AvailabilityNotFoundException extends RuntimeException {
    private String message;
    public AvailabilityNotFoundException(String message){
        super(message);
        this.message = message;
    }
}
