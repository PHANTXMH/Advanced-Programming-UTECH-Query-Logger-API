package com.ap.covid19.api.apcovid19.services;

import com.ap.covid19.api.apcovid19.interfaces.ComplaintsInt;
import com.ap.covid19.api.apcovid19.models.Complaints;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComplaintsService implements ComplaintsInt {

    @Override
    public List<Complaints> getAllComplainsByStudentID(final Long studentID) {
        return null;
    }

    @Override
    public Complaints createComplaints(Complaints complaints) {
        return null;
    }

    @Override
    public Complaints updateComplaints(Complaints complaints) {
        return null;
    }

    @Override
    public Complaints deleteComplaints(Long complaintID) {
        return null;
    }
}
