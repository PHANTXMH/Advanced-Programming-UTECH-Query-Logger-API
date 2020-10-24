package com.ap.covid19.api.apcovid19.security.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class LoginForm {

    @NotBlank
    @Size(min=7, max = 7)
    private String username;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

}
