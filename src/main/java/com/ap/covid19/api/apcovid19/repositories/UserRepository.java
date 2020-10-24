package com.ap.covid19.api.apcovid19.repositories;


import com.ap.covid19.api.apcovid19.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByUserName(Long username);


    Optional<User> findByEmail(String email);


}
