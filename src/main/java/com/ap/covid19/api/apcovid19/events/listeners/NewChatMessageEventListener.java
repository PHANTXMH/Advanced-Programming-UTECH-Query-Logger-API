package com.ap.covid19.api.apcovid19.events.listeners;

import com.ap.covid19.api.apcovid19.events.NewChatMessageEvent;
import com.ap.covid19.api.apcovid19.models.Chat;
import com.ap.covid19.api.apcovid19.models.ChatMessages;
import com.ap.covid19.api.apcovid19.models.User;
import com.ap.covid19.api.apcovid19.repositories.ChatMessageRepository;
import com.ap.covid19.api.apcovid19.repositories.ChatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Optional;

@RequiredArgsConstructor
@Async
@Slf4j
@Component
public class NewChatMessageEventListener implements ApplicationListener<NewChatMessageEvent> {

    private final ChatRepository chatRepository;

    private final ChatMessageRepository chatMessageRepository;

    @Override
    public void onApplicationEvent(NewChatMessageEvent newChatMessageEvent) {

        Assert.notNull(newChatMessageEvent, "newChatMessageEvent cannot be null");

        Chat chatExist = chatRepository.getChatByTo_IdAndFrom_Id(newChatMessageEvent.getMessage().getTo(), newChatMessageEvent.getMessage().getFrom());

        Long chatID;
        Chat chat;
        if(chatExist != null){
            chatID = chatExist.getId();
            chat = chatExist;
        }else{
            // create new record and save to db then save the messages
            chat = new Chat(new User(newChatMessageEvent.getMessage().getTo()), new User(newChatMessageEvent.getMessage().getFrom()));
            chatRepository.save(chat);
            chatID = chat.getId();
        }

        ChatMessages chatMessages = new ChatMessages(newChatMessageEvent.getMessage().getMessage(), Boolean.FALSE);

        chatMessages.setChat(chat);

        chatMessages.setSendBy(new User(newChatMessageEvent.getMessage().getFrom()));

        chatMessageRepository.save(chatMessages);

        log.info("Chat message was saved successfully");

        // attempt to save the messages
    }

}
