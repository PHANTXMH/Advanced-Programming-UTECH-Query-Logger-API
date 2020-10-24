package com.ap.covid19.api.apcovid19.services;

import com.ap.covid19.api.apcovid19.enumerations.Role;
import com.ap.covid19.api.apcovid19.exceptions.UserNotFoundException;
import com.ap.covid19.api.apcovid19.interfaces.UsersInt;
import com.ap.covid19.api.apcovid19.models.User;
import com.ap.covid19.api.apcovid19.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class UsersService extends BaseServiceHelper implements UsersInt {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(Sort.by("last_name", "desc"));
    }

    @Override
    public List<User> getAllUsersByRole(final Role role) {
        return userRepository.findAllByRole(role);
    }

    @Override
    public User getUserByID(final Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException(String.format("User with ID %s not found", id)));
    }
}
