package com.ap.covid19.api.apcovid19.repositories;

import com.ap.covid19.api.apcovid19.models.LiveChatAvailableTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiveChatAvailabilityTimeRepository extends JpaRepository<LiveChatAvailableTime, Long> {

}
