package com.ap.covid19.api.apcovid19.events;

import com.ap.covid19.api.apcovid19.models.LiveChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

@Slf4j
public class NewChatMessageEvent extends ApplicationEvent {
    private LiveChatMessage message;
    public NewChatMessageEvent(LiveChatMessage message, Object source) {
        super(source);
        log.info("Event publish from source: {} with data: {}", source, message.toString());
        this.message = message;
    }

    public LiveChatMessage getMessage() {
        return message;
    }

    public void setMessage(LiveChatMessage message) {
        this.message = message;
    }
}
