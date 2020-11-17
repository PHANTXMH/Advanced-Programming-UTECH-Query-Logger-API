package com.ap.covid19.api.apcovid19.interfaces;

import com.ap.covid19.api.apcovid19.models.ApiResponse;
import com.ap.covid19.api.apcovid19.models.ComplaintResponses;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface ComplaintResponseInt {

    ApiResponse<ComplaintResponses> reply(ComplaintResponses complaintResponses) throws IllegalAccessException;

    @Async
    void readComplaint(Long complaintID) throws IllegalAccessException;

    List<ComplaintResponses> getAllComplaintResponsesByComplaintID(Long complaintID);

    List<ComplaintResponses> getAllComplaintResponsesByComplaintIDAndUserID(Long complaintID, Long userID);

    List<ComplaintResponses> getAllComplaintResponsesByUserID(Long userID);
}
