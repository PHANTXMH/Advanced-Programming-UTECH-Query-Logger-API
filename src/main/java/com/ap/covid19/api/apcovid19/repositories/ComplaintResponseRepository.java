package com.ap.covid19.api.apcovid19.repositories;

import com.ap.covid19.api.apcovid19.models.ComplaintResponses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintResponseRepository extends JpaRepository<ComplaintResponses, Long> {

    List<ComplaintResponses> findAllByComplaints_Id(Long complaintID);

    List<ComplaintResponses> findAllByComplaints_IdAndCreatedUser_Id(Long complaintID, Long userID);

    List<ComplaintResponses> findAllByCreatedUser_Id(Long userID);


}
