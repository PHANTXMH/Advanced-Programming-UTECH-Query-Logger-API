package com.ap.covid19.api.apcovid19.interfaces;

import com.ap.covid19.api.apcovid19.models.ApiResponse;
import com.ap.covid19.api.apcovid19.models.Complaints;

import java.util.List;

public interface ComplaintsInt {

    List<Complaints> getAllComplainsByStudentID(final Long studentID);

    Complaints createComplaints(final Complaints complaints) throws IllegalAccessException;

    ApiResponse<Complaints> updateComplaints(final Complaints complaints) throws IllegalAccessException;

    ApiResponse<Complaints> deleteComplaints(final Long complaintID);

}
