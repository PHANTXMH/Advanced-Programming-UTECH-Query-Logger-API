package com.ap.covid19.api.apcovid19.interfaces;

import com.ap.covid19.api.apcovid19.models.Chat;
import com.ap.covid19.api.apcovid19.models.ChatMessages;

import java.util.List;

public interface ChatMessageImp {

    List<Chat> getChatMessageForUser() throws IllegalAccessException;

    Chat getMessagesByFromAndToUser(Long from, Long to);

    List<ChatMessages> getMessagesByChatID(Long chatID);


}
