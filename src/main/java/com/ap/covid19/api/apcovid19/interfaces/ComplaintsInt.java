package com.ap.covid19.api.apcovid19.interfaces;

import com.ap.covid19.api.apcovid19.enumerations.ComplainStatus;
import com.ap.covid19.api.apcovid19.models.ApiResponse;
import com.ap.covid19.api.apcovid19.models.Complaints;

import java.util.List;

public interface ComplaintsInt {

    List<Complaints> getAllComplainsByStudentID(final Long studentID);

    ApiResponse<Complaints> createComplaints(final Complaints complaints) throws IllegalAccessException;

    Complaints getComplaintsByID(final Long complaintID);

    ApiResponse<Complaints> updateComplaints(final Complaints complaints) throws IllegalAccessException;

    ApiResponse<Complaints> updateComplaints(final Long complaintID, ComplainStatus complainStatus) throws IllegalAccessException;

    ApiResponse<Complaints> deleteComplaints(final Long complaintID);

    List<Complaints> findAllComplaintsByServiceID(Long serviceID);

    List<Complaints> getAllComplainsByStudentIDAndStatus(Long studentID, ComplainStatus complainStatus);

    List<Complaints> getComplaintsByDistinctUserAndStatus(ComplainStatus complainStatus);

}
