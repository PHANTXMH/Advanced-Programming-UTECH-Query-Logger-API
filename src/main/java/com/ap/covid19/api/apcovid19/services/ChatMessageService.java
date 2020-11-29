package com.ap.covid19.api.apcovid19.services;

import com.ap.covid19.api.apcovid19.interfaces.ChatMessageImp;
import com.ap.covid19.api.apcovid19.models.Chat;
import com.ap.covid19.api.apcovid19.repositories.ChatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ChatMessageService extends BaseServiceHelper implements ChatMessageImp {

    private final ChatRepository chatRepository;

    @Override
    public List<Chat> getChatMessageForUser() throws IllegalAccessException {
        return chatRepository.getAllByTo_Id(getAuthenticatedUser().getId());
    }

}
