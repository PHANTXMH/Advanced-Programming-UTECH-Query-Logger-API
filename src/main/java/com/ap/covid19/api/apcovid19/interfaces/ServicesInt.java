package com.ap.covid19.api.apcovid19.interfaces;

import com.ap.covid19.api.apcovid19.models.Complaints;
import com.ap.covid19.api.apcovid19.models.Services;

import java.util.List;

public interface ServicesInt {

    List<Services> getAllServices();

    Services findServiceByID(Long serviceID);

    List<Complaints> findAllServiceComplaintsByServiceID(Long serviceID);


}
