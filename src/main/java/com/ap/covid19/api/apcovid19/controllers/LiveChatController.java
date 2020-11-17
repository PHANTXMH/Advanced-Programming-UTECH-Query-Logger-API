package com.ap.covid19.api.apcovid19.controllers;

import com.ap.covid19.api.apcovid19.models.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;


@Controller
@RequiredArgsConstructor
public class LiveChatController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/v1/send/message")
    @SendTo({"/user/target/"})
    public Greeting greeting(Greeting message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
