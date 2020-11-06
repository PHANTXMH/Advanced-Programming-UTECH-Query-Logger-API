package com.ap.covid19.api.apcovid19.repositories;

import com.ap.covid19.api.apcovid19.enumerations.Day;
import com.ap.covid19.api.apcovid19.models.LiveChatAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LiveChatAvailabilityRepository extends JpaRepository<LiveChatAvailability, Long> {

    Optional<LiveChatAvailability> findFirstByDayAndUser_Id(Day day, Long userID);


    List<LiveChatAvailability> findAllByUser_Id(Long userID);

}
