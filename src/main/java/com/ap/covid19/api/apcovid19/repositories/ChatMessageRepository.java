package com.ap.covid19.api.apcovid19.repositories;

import com.ap.covid19.api.apcovid19.models.ChatMessages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessages, Long> {


    List<ChatMessages> findAllByChat_Id(Long chatID);

}
