package com.ap.covid19.api.apcovid19.services;

import com.ap.covid19.api.apcovid19.exceptions.ComplaintNotFoundException;
import com.ap.covid19.api.apcovid19.exceptions.ComplaintResponseNotFoundException;
import com.ap.covid19.api.apcovid19.interfaces.ComplaintResponseInt;
import com.ap.covid19.api.apcovid19.models.ApiResponse;
import com.ap.covid19.api.apcovid19.models.ComplaintResponses;
import com.ap.covid19.api.apcovid19.models.Complaints;
import com.ap.covid19.api.apcovid19.models.User;
import com.ap.covid19.api.apcovid19.repositories.ComplaintResponseRepository;
import com.ap.covid19.api.apcovid19.repositories.ComplaintsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ComplaintResponseService extends BaseServiceHelper implements ComplaintResponseInt {

    private final ComplaintResponseRepository complaintResponseRepository;

    private final ComplaintsRepository complaintsRepository;

    @Override
    public ApiResponse<ComplaintResponses> reply(ComplaintResponses complaintResponses) throws IllegalAccessException {

        Assert.notNull(complaintResponses, "Complaint response cannot be null");

        Assert.notNull(complaintResponses.getComplaints(), "Complaint Object cannot be null");

        Complaints complaints = complaintsRepository.findById(complaintResponses.getComplaints().getId()).orElseThrow(() ->
                new ComplaintNotFoundException(String.format("Complaint with ID %s don't exists", complaintResponses.getComplaints().getId())));

        // validate the complaint if necessary

        User authenticatedUser = getAuthenticatedUser();

        complaintResponses.setCreatedUser(authenticatedUser);

        complaintResponses.setModifyUser(authenticatedUser);

        complaintResponseRepository.save(complaintResponses);

        return new ApiResponse<ComplaintResponses>(HttpStatus.OK, "Response was saved successfully", null, complaintResponses, true);

    }

    @Async
    @Override
    public void readComplaint(Long complaintID) throws IllegalAccessException {
        User user = getAuthenticatedUser();
        ComplaintResponses complaintResponses = complaintResponseRepository.findById(complaintID).orElseThrow(() -> new
                ComplaintResponseNotFoundException(String.format("Complaint Response with ID not found %s", complaintID)));
        complaintResponses.setRead(true);
        complaintResponses.setReadDate(Calendar.getInstance().getTime());
        complaintResponseRepository.save(complaintResponses);
    }

    @Override
    public List<ComplaintResponses> getAllComplaintResponsesByComplaintID(Long complaintID) {
        return complaintResponseRepository.findAllByComplaints_Id(complaintID);
    }

    @Override
    public List<ComplaintResponses> getAllComplaintResponsesByComplaintIDAndUserID(Long complaintID, Long userID) {
        return complaintResponseRepository.findAllByComplaints_IdAndCreatedUser_Id(complaintID, userID);
    }

    @Override
    public List<ComplaintResponses> getAllComplaintResponsesByUserID(Long userID) {
        return complaintResponseRepository.findAllByCreatedUser_Id(userID);
    }

}
