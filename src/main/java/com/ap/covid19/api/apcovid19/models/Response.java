package com.ap.covid19.api.apcovid19.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Response<T> {

    private boolean success;
    private boolean message;
    private Set<String> errorMessages;
    private Object object;

}
