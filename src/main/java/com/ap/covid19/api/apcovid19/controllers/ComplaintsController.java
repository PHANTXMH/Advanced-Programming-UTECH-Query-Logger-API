package com.ap.covid19.api.apcovid19.controllers;

import com.ap.covid19.api.apcovid19.models.Complaints;
import com.ap.covid19.api.apcovid19.services.ComplaintsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/complaints")
public class ComplaintsController {

    private final ComplaintsService complaintsService;


    @GetMapping(value = "/by/student/id/{student_id}", produces = "application/json")
    public ResponseEntity<List<Complaints>> getComplaintsByStudentID(@PathVariable("student_id") Long studentID){
        return new ResponseEntity<>(complaintsService.getAllComplainsByStudentID(studentID), HttpStatus.OK);
    }


    @PostMapping(value = "/create", produces = "application/json")
    public ResponseEntity<Complaints> createComplaints(@Valid @RequestBody Complaints complaints){
        return new ResponseEntity<>(complaintsService.createComplaints(complaints), HttpStatus.OK);
    }


    @PutMapping(value = "/update", produces = "application/json")
    public ResponseEntity<Complaints> updateComplaints(@Valid @RequestBody Complaints complaints){
        return new ResponseEntity<>(complaintsService.updateComplaints(complaints), HttpStatus.OK);
    }


    @PutMapping(value = "/delete/{complaint_id}", produces = "application/json")
    public ResponseEntity<Complaints> deleteComplaints(@PathVariable("complaint_id") Long complaintID){
        return new ResponseEntity<>(complaintsService.deleteComplaints(complaintID), HttpStatus.OK);
    }


}
