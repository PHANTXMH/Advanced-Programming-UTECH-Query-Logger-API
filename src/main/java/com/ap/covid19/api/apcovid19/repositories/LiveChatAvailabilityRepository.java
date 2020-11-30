package com.ap.covid19.api.apcovid19.repositories;

import com.ap.covid19.api.apcovid19.models.LiveChatAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiveChatAvailabilityRepository extends JpaRepository<LiveChatAvailability, Long> {

   // Optional<LiveChatAvailability> findFirstBy(Day day, Long userID);

    LiveChatAvailability findByUser_Id(Long userID);

}
