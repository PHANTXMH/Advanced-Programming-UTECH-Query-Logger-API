package com.ap.covid19.api.apcovid19.controllers;

import com.ap.covid19.api.apcovid19.enumerations.Role;
import com.ap.covid19.api.apcovid19.models.User;
import com.ap.covid19.api.apcovid19.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {

    private final UsersService usersService;

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(usersService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/by/id/{id}", produces = "application/json")
    public ResponseEntity<User> getAllUsers(@PathVariable("id") Long id){
        return new ResponseEntity<>(usersService.getUserByID(id), HttpStatus.OK);
    }

    @GetMapping(value = "/by/id/{role}", produces = "application/json")
    public ResponseEntity<List<User>> getAllUsers(@PathVariable("role") Role role){
        return new ResponseEntity<>(usersService.getAllUsersByRole(role), HttpStatus.OK);
    }

}
