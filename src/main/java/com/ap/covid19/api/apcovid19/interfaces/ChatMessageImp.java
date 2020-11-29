package com.ap.covid19.api.apcovid19.interfaces;

import com.ap.covid19.api.apcovid19.models.Chat;

import java.util.List;

public interface ChatMessageImp {

    public List<Chat> getChatMessageForUser() throws IllegalAccessException;

  //  public List<Chat> getMessagesByFromAndToUser() throws IllegalAccessException;


}
