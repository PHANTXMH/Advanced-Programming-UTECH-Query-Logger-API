package com.ap.covid19.api.apcovid19.repositories;

import com.ap.covid19.api.apcovid19.models.Services;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesRepository extends JpaRepository<Services, Long> {
}
