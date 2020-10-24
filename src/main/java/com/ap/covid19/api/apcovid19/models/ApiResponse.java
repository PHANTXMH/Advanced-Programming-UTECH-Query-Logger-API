package com.ap.covid19.api.apcovid19.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private HttpStatus status;
    private String message;
    private List<String> errors;
    private Object data;
    private boolean success;

    public ApiResponse(HttpStatus status, String message, List<String> errors){
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
}
