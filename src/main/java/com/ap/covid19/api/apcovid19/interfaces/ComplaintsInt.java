package com.ap.covid19.api.apcovid19.interfaces;

import com.ap.covid19.api.apcovid19.models.Complaints;

import java.util.List;

public interface ComplaintsInt {

    List<Complaints> getAllComplainsByStudentID(final Long studentID);

    Complaints createComplaints(final Complaints complaints);

    Complaints updateComplaints(final Complaints complaints);

    Complaints deleteComplaints(final Long complaintID);

}
