package com.ap.covid19.api.apcovid19.services;


import com.ap.covid19.api.apcovid19.enumerations.ComplainStatus;
import com.ap.covid19.api.apcovid19.models.User;
import com.ap.covid19.api.apcovid19.security.services.UserPrinciple;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BaseServiceHelper {


    public UserPrinciple getUserDetails(){
        UserPrinciple userPrinciple = null;
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(object instanceof UserPrinciple){
            userPrinciple = (UserPrinciple) object;
            return userPrinciple;
        }
        return userPrinciple;
    }

    public User getAuthenticatedUser() throws IllegalAccessException {
        UserPrinciple userPrinciple = this.getUserDetails();
        if (userPrinciple == null)
            throw new IllegalAccessException("Could not find Authenticated User");
        return new User(userPrinciple.getId(), userPrinciple.getEmail());
    }

    public boolean isComplaintEditable(final ComplainStatus complainStatus){
        return Arrays.asList(ComplainStatus.NEW, ComplainStatus.UNRESOLVED).contains(complainStatus);
    }

}
