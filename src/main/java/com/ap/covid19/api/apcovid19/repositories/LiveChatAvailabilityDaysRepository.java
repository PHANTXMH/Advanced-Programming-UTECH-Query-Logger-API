package com.ap.covid19.api.apcovid19.repositories;

import com.ap.covid19.api.apcovid19.models.LiveChatAvailableDays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiveChatAvailabilityDaysRepository extends JpaRepository<LiveChatAvailableDays, Long> {

}
