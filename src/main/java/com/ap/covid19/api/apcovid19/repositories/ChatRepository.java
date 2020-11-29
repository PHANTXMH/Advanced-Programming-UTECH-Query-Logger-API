package com.ap.covid19.api.apcovid19.repositories;

import com.ap.covid19.api.apcovid19.models.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    Chat getChatByTo_IdAndFrom_Id(Long to, Long from);

    boolean existsChatsByTo_IdAndFrom_Id(Long to, Long from);

    List<Chat> getAllByTo_Id(Long to);

}
