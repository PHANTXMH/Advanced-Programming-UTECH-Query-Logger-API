package com.ap.covid19.api.apcovid19.services;

import com.ap.covid19.api.apcovid19.exceptions.ServiceNotFoundException;
import com.ap.covid19.api.apcovid19.interfaces.ServicesInt;
import com.ap.covid19.api.apcovid19.models.Complaints;
import com.ap.covid19.api.apcovid19.models.Services;
import com.ap.covid19.api.apcovid19.repositories.ServicesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ServicesService extends BaseServiceHelper implements ServicesInt {

    private final ServicesRepository servicesRepository;

    private final ComplaintsService complaintsService;

    @Override
    public List<Services> getAllServices() {
        return servicesRepository.findAll(Sort.by("name"));
    }

    @Override
    public Services findServiceByID(Long serviceID) {
        return servicesRepository.findById(serviceID).orElseThrow(() ->
                new ServiceNotFoundException(String.format("No service with ID %s Found", serviceID)));
    }

    @Override
    public List<Complaints> findAllServiceComplaintsByServiceID(Long serviceID) {
        return complaintsService.findAllComplaintsByServiceID(serviceID);
    }

}
