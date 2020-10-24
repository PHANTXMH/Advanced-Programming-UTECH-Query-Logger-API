package com.ap.covid19.api.apcovid19.repositories;


import com.ap.covid19.api.apcovid19.enumerations.Role;
import com.ap.covid19.api.apcovid19.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByUserName(String username);


    Optional<User> findByEmail(String email);


    List<User> findAllByRole(Role role);


}
