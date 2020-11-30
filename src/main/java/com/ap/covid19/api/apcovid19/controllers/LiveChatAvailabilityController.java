package com.ap.covid19.api.apcovid19.controllers;

import com.ap.covid19.api.apcovid19.models.ApiResponse;
import com.ap.covid19.api.apcovid19.models.LiveChatAvailability;
import com.ap.covid19.api.apcovid19.models.LiveChatAvailableDays;
import com.ap.covid19.api.apcovid19.services.LiveChatAvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/availability/chat/time")
public class LiveChatAvailabilityController {

    private final LiveChatAvailabilityService liveChatAvailabilityService;

    @PostMapping(value = "/create", produces = "application/json")
    public ResponseEntity<ApiResponse<LiveChatAvailability>> createAvailableDays(@Valid @RequestBody LiveChatAvailability liveChatAvailability) throws IllegalAccessException {
        return new ResponseEntity<>(liveChatAvailabilityService.createAvailableDays(liveChatAvailability), HttpStatus.OK);
    }

    @PostMapping(value = "/add/time/slot", produces = "application/json")
    public ResponseEntity<ApiResponse<LiveChatAvailableDays>> addAvailableTimeSlot(@Valid @RequestBody LiveChatAvailableDays liveChatAvailableTime){
        return new ResponseEntity<>(liveChatAvailabilityService.addAvailableTimeSlot(liveChatAvailableTime), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<ApiResponse> deleteAvailableDayByID(@PathVariable("id") Long id) throws IllegalAccessException {
        return new ResponseEntity<>(liveChatAvailabilityService.deleteAvailableDays(id), HttpStatus.OK);
    }

    @GetMapping(value = "/all/by/student/rep/id/{id}", produces = "application/json")
    public ResponseEntity<LiveChatAvailability> getAllLiveChatAvailableDaysByStudentRepID(@PathVariable("id") Long id){
        return new ResponseEntity<>(liveChatAvailabilityService.viewAllByStudentRepID(id), HttpStatus.OK);
    }

}
