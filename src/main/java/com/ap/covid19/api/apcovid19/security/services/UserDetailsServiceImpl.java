package com.ap.covid19.api.apcovid19.security.services;

import com.ap.covid19.api.apcovid19.repositories.UserRepository;
import com.ap.covid19.api.apcovid19.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(Long.parseLong(username))
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not found with username: " + username));
        return UserPrinciple.build(user);

    }

    @Transactional
    public UserDetails loadByEmail(String email) throws UsernameNotFoundException {

        User passenger = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not found with email address: " + email));
        return UserPrinciple.build(passenger);

    }
}
