package com.ap.covid19.api.apcovid19.services;

import com.ap.covid19.api.apcovid19.interfaces.ChatMessageImp;
import com.ap.covid19.api.apcovid19.models.Chat;
import com.ap.covid19.api.apcovid19.models.ChatMessages;
import com.ap.covid19.api.apcovid19.repositories.ChatMessageRepository;
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

    private final ChatMessageRepository chatMessageRepository;

    @Override
    public List<Chat> getChatMessageForUser() throws IllegalAccessException {
        return chatRepository.getAllByTo_Id(getAuthenticatedUser().getId());
    }

    @Override
    public Chat getMessagesByFromAndToUser(Long from, Long to){
        return chatRepository.getChatByTo_IdAndFrom_IdOrTo_IdAndFrom_Id(to, from, from, to);
    }

    @Override
    public List<ChatMessages> getMessagesByChatID(Long chatID) {
        return chatMessageRepository.findAllByChat_Id(chatID);
    }

}
