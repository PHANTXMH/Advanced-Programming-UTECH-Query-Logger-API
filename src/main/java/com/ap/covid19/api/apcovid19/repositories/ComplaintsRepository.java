package com.ap.covid19.api.apcovid19.repositories;

import com.ap.covid19.api.apcovid19.enumerations.ComplainStatus;
import com.ap.covid19.api.apcovid19.models.Complaints;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ComplaintsRepository extends JpaRepository<Complaints, Long> {

    List<Complaints> findAllByCreatedUser_IdOrderByCreatedAtDesc(Long userID);

    Optional<Complaints> findAllByCreatedUser_IdAndId(Long userID, Long complaintID);

    List<Complaints> findAllByServices_Id(Long complaintID);

    List<Complaints> findAllByCreatedUser_IdAndComplainStatusOrderByCreatedAtDesc(Long userID, ComplainStatus complainStatus);


}
