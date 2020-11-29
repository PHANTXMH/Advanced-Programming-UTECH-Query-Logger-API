package com.ap.covid19.api.apcovid19.controllers;

import com.ap.covid19.api.apcovid19.events.NewChatMessageEvent;
import com.ap.covid19.api.apcovid19.models.LiveChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller
@RequiredArgsConstructor
public class LiveChatController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    private final ApplicationEventPublisher applicationEventPublisher;

    @MessageMapping("/v1/send/message/{to}")
    public LiveChatMessage deliverMessage(LiveChatMessage liveChatMessage) throws Exception {
        Thread.sleep(1000); // simulated delay
        simpMessagingTemplate.convertAndSend("/user/target/" + liveChatMessage.getTo(), liveChatMessage);
        applicationEventPublisher.publishEvent(new NewChatMessageEvent(liveChatMessage, this));
        return liveChatMessage;
    }
}
