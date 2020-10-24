package com.ap.covid19.api.apcovid19.exceptions;

public class ServiceNotFoundException extends RuntimeException {
    private String message;
    public ServiceNotFoundException(String message){
        super(message);
        this.message = message;
    }
}
