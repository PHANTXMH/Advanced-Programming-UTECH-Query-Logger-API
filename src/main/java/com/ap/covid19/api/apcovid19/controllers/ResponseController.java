package com.ap.covid19.api.apcovid19.controllers;

import com.ap.covid19.api.apcovid19.models.ApiResponse;
import com.ap.covid19.api.apcovid19.models.ComplaintResponses;
import com.ap.covid19.api.apcovid19.services.ComplaintResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/response")
public class ResponseController {


    private final ComplaintResponseService complaintResponseService;

    @PostMapping(value = "/reply", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ApiResponse<ComplaintResponses>> reply(@RequestBody @Validated ComplaintResponses complaintResponses) throws IllegalAccessException {
        return new ResponseEntity<>(complaintResponseService.reply(complaintResponses), HttpStatus.CREATED);
    }

    @GetMapping(value = "/by/complaint/{complaint_id}", produces = "application/json")
    public ResponseEntity<List<ComplaintResponses>> getResponseByComplaint(@PathVariable("complaint_id") Long complaintID) {
        return new ResponseEntity<>(complaintResponseService.getAllComplaintResponsesByComplaintID(complaintID), HttpStatus.CREATED);
    }

    @GetMapping(value = "/by/complaint/and/user/{complaint_id}/{user_id}", produces = "application/json")
    public ResponseEntity<List<ComplaintResponses>> getResponseByComplaintAndUser(@PathVariable("complaint_id") Long complaintID,
                                                                           @PathVariable("user_id") Long userID) {
        return new ResponseEntity<>(complaintResponseService.getAllComplaintResponsesByComplaintIDAndUserID(complaintID, userID), HttpStatus.CREATED);
    }

    @GetMapping(value = "/by/user/id/{user_id}", produces = "application/json")
    public ResponseEntity<List<ComplaintResponses>> getResponseByUser(@PathVariable("user_id") Long userID) {
        return new ResponseEntity<>(complaintResponseService.getAllComplaintResponsesByUserID(userID), HttpStatus.CREATED);
    }


    @GetMapping(value = "/read/{response_id}", produces = "application/json")
    public void readComplaint(@PathVariable("response_id") Long responseID) throws IllegalAccessException {
        complaintResponseService.readComplaint(responseID);
    }


    @GetMapping(value = "/by/id/{id}", produces = "application/json")
    public ResponseEntity<ComplaintResponses> getResponseByID(@PathVariable("id") Long id) {
        return new ResponseEntity<>(complaintResponseService.byID(id), HttpStatus.CREATED);
    }

}
