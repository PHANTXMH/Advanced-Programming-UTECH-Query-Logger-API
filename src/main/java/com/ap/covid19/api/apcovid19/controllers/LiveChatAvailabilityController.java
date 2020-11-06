package com.ap.covid19.api.apcovid19.controllers;

import com.ap.covid19.api.apcovid19.models.ApiResponse;
import com.ap.covid19.api.apcovid19.models.LiveChatAvailability;
import com.ap.covid19.api.apcovid19.services.LiveChatAvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/availability/chat/time")
public class LiveChatAvailabilityController {

    private final LiveChatAvailabilityService liveChatAvailabilityService;

    @PostMapping(value = "/create", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ApiResponse> createAvailableDays(@Valid @RequestBody List<LiveChatAvailability> liveChatAvailabilities){
        return new ResponseEntity<>(liveChatAvailabilityService.createAvailableDays(liveChatAvailabilities), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<ApiResponse> deleteAvailableDayByID(@PathVariable("id") Long id) throws IllegalAccessException {
        return new ResponseEntity<>(liveChatAvailabilityService.deleteAvailableDays(id), HttpStatus.OK);
    }

    @GetMapping(value = "/all/by/student/rep/id/{id}", produces = "application/json")
    public ResponseEntity<List<LiveChatAvailability>> getAllLiveChatAvailableDaysByStudentRepID(@PathVariable("id") Long id){
        return new ResponseEntity<>(liveChatAvailabilityService.viewAllByStudentRepID(id), HttpStatus.OK);
    }

}
