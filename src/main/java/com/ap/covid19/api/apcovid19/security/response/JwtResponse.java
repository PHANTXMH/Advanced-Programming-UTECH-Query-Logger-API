package com.ap.covid19.api.apcovid19.security.response;

import com.ap.covid19.api.apcovid19.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private User user;

    public JwtResponse(String accessToken, User user) {
        this.token = accessToken;
        this.user = user;
    }

}
