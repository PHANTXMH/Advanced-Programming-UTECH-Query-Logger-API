package com.ap.covid19.api.apcovid19.controllers;

import com.ap.covid19.api.apcovid19.enumerations.ComplainStatus;
import com.ap.covid19.api.apcovid19.models.ApiResponse;
import com.ap.covid19.api.apcovid19.models.Complaints;
import com.ap.covid19.api.apcovid19.services.ComplaintsService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/complaints")
public class ComplaintsController {

    private final ComplaintsService complaintsService;


    @PostMapping(value = "/create", produces = "application/json")
    public ResponseEntity<ApiResponse<Complaints>> createComplaints(@Valid @RequestBody Complaints complaints) throws IllegalAccessException {
        return new ResponseEntity<>(complaintsService.createComplaints(complaints), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update", produces = "application/json")
    public ResponseEntity<ApiResponse<Complaints>> updateComplaints(@Valid @RequestBody Complaints complaints) throws IllegalAccessException {
        return new ResponseEntity<>(complaintsService.updateComplaints(complaints), HttpStatus.OK);
    }

    @PutMapping(value = "/update/status", produces = "application/json", params = {"complaintID", "status"})
    @ApiOperation(value = "Update Complaint Status")
    public ResponseEntity<ApiResponse<Complaints>> updateComplaintsStatus(@RequestParam("complaintID") Long complaintID,
                                                                    @RequestParam("status") ComplainStatus status) throws IllegalAccessException {
        return new ResponseEntity<>(complaintsService.updateComplaints(complaintID, status), HttpStatus.OK);
    }


    @DeleteMapping(value = "/delete/{complaint_id}", produces = "application/json")
    public ResponseEntity<ApiResponse<Complaints>> deleteComplaints(@PathVariable("complaint_id") Long complaintID){
        return new ResponseEntity<>(complaintsService.deleteComplaints(complaintID), HttpStatus.OK);
    }

    @GetMapping(value = "/by/student/id/{student_id}", produces = "application/json")
    public ResponseEntity<List<Complaints>> getComplaintsByStudentID(@PathVariable("student_id") Long studentID){
        return new ResponseEntity<>(complaintsService.getAllComplainsByStudentID(studentID), HttpStatus.OK);
    }

    @GetMapping(value = "/by/student/id/and/status/{student_id}/{status}", produces = "application/json")
    public ResponseEntity<List<Complaints>> getComplaintsByStudentIDAndStatus(@PathVariable("student_id") Long studentID, @PathVariable("status") ComplainStatus status){
        return new ResponseEntity<>(complaintsService.getAllComplainsByStudentIDAndStatus(studentID, status), HttpStatus.OK);
    }

    @GetMapping(value = "/by/id/{complaint_id}", produces = "application/json")
    public ResponseEntity<Complaints> getComplaintsByID(@PathVariable("complaint_id") Long complaintID){
        return new ResponseEntity<>(complaintsService.getComplaintsByID(complaintID), HttpStatus.OK);
    }

    @GetMapping(value = "/all/distinct/user/and/status/{status}", produces = "application/json")
    public ResponseEntity<List<Complaints>> getComplaintsByDistinctUserAndStatus(@PathVariable("status") ComplainStatus status){
        return new ResponseEntity<>(complaintsService.getComplaintsByDistinctUserAndStatus(status), HttpStatus.OK);
    }


}
