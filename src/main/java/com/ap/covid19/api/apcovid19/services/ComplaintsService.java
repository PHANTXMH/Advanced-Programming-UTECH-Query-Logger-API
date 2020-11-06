package com.ap.covid19.api.apcovid19.services;

import com.ap.covid19.api.apcovid19.enumerations.ComplainStatus;
import com.ap.covid19.api.apcovid19.exceptions.ComplaintNotFoundException;
import com.ap.covid19.api.apcovid19.interfaces.ComplaintsInt;
import com.ap.covid19.api.apcovid19.models.ApiResponse;
import com.ap.covid19.api.apcovid19.models.Complaints;
import com.ap.covid19.api.apcovid19.repositories.ComplaintsRepository;
import com.ap.covid19.api.apcovid19.repositories.ServicesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComplaintsService extends BaseServiceHelper implements ComplaintsInt {

    private final ComplaintsRepository complaintsRepository;

    private final ServicesRepository servicesRepository;

    @Override
    public List<Complaints> getAllComplainsByStudentID(final Long studentID) {

        return complaintsRepository.findAllByCreatedUser_IdOrderByCreatedAtDesc(studentID);

    }

    @Override
    public ApiResponse<Complaints> createComplaints(Complaints complaints) throws IllegalAccessException{

        complaints.setCreatedUser(this.getAuthenticatedUser());

        complaints.setComplainStatus(ComplainStatus.NEW);

        complaintsRepository.save(complaints);

        return new ApiResponse<>(HttpStatus.OK, "Complaint was created successfully", null, complaints, true);
    }

    @Override
    public Complaints getComplaintsByID(Long complaintID) {

        return complaintsRepository.findById(complaintID).orElseThrow(() ->
                new ComplaintNotFoundException(String.format("Complaint with ID %s not found", complaintID)));
    }

    @Override
    public ApiResponse<Complaints> updateComplaints(Complaints complaints) throws IllegalAccessException, IllegalStateException{

        Complaints complaintToEdit = complaintsRepository.findAllByCreatedUser_IdAndId(this.getUserDetails().getId(), complaints.getId()).orElseThrow( () -> new
                ComplaintNotFoundException(
                        String.format("Complain with ID %s does found exists or user dont't have permission to update the complaint",
                                complaints.getId()))
        );

        final boolean isComplaintEditable = this.isComplaintEditable(complaintToEdit.getComplainStatus());

        if (!isComplaintEditable)
            throw new IllegalStateException(String.format("Complaint with status %s can't be edited", complaintToEdit.getComplainStatus().name()));

        if (complaints.getServices() != null && complaints.getServices().getId() != null) // if th user chose to edit the service then check if the new or old one exists
        servicesRepository.findById(complaints.getServices().getId()).orElseThrow(() -> new
                ComplaintNotFoundException(String.format("Service with ID %s does not exists", complaints.getServices().getComplaints())));

        complaintToEdit.setQuery(complaints.getQuery());

        complaintToEdit.setModifyUser(this.getAuthenticatedUser());

        complaintToEdit.setServices(complaints.getServices());

        complaintsRepository.save(complaintToEdit); // update the record

        return new ApiResponse<>(HttpStatus.OK, "Complaint was successfully updated", null, complaintToEdit, true);
    }

    @Override
    public ApiResponse<Complaints> deleteComplaints(Long complaintID) {

        Complaints complaintToDelete = complaintsRepository.findAllByCreatedUser_IdAndId(this.getUserDetails().getId(), complaintID).orElseThrow( () -> new
                ComplaintNotFoundException(
                String.format("Complain with ID %s does found exists or user dont't have permission to delete the complaint",
                        complaintID))
        );

        // complaint was found since no exception was thrown, so proceed with deleting the complaint

        complaintsRepository.delete(complaintToDelete);

        return new ApiResponse<>(HttpStatus.OK, "Complaint was successfully deleted", null, null, true);
    }

    @Override
    public List<Complaints> findAllComplaintsByServiceID(Long serviceID) {
        return complaintsRepository.findAllByServices_Id(serviceID);
    }

    @Override
    public List<Complaints> getAllComplainsByStudentIDAndStatus(Long studentID, ComplainStatus complainStatus) {
        return complaintsRepository.findAllByCreatedUser_IdAndComplainStatusOrderByCreatedAtDesc(studentID, complainStatus);
    }

    @Override
    public List<Complaints> getComplaintsByDistinctUserAndStatus(ComplainStatus complainStatus) {
        return complaintsRepository.findDistinctCreatedUser_IdAndAndComplainStatus(complainStatus);
    }
}
