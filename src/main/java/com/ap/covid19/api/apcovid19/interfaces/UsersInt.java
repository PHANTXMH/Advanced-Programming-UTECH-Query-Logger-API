package com.ap.covid19.api.apcovid19.interfaces;

import com.ap.covid19.api.apcovid19.enumerations.Role;
import com.ap.covid19.api.apcovid19.models.User;

import java.util.List;

public interface UsersInt {

    List<User> getAllUsers();

    List<User> getAllUsersByRole(Role role);

    User getUserByID(Long id);

}
