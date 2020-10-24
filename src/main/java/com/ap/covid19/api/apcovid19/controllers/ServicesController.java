package com.ap.covid19.api.apcovid19.controllers;

import com.ap.covid19.api.apcovid19.models.Complaints;
import com.ap.covid19.api.apcovid19.models.Services;
import com.ap.covid19.api.apcovid19.services.ServicesService;
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
@RequestMapping("/v1/services")
public class ServicesController {

    private final ServicesService servicesService;

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<Services>> getAllServices(){
        return new ResponseEntity<>(servicesService.getAllServices(), HttpStatus.OK);
    }

    @GetMapping(value = "/by/id/{service_id}", produces = "application/json")
    public ResponseEntity<Services> getServiceByID(@PathVariable("service_id") Long serviceID){
        return new ResponseEntity<>(servicesService.findServiceByID(serviceID), HttpStatus.OK);
    }

    @GetMapping(value = "/complaints/by/id/{service_id}", produces = "application/json")
    public ResponseEntity<List<Complaints>> getAllComplaintsByServiceID(@PathVariable("service_id") Long serviceID){
        return new ResponseEntity<>(servicesService.findAllServiceComplaintsByServiceID(serviceID), HttpStatus.OK);
    }

}
