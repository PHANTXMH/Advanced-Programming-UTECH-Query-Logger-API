package com.ap.covid19.api.apcovid19.controllers;

import com.ap.covid19.api.apcovid19.models.Chat;
import com.ap.covid19.api.apcovid19.services.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/v1/chat/messages")
@RestController
public class ChatMessagesController {

    private final ChatMessageService chatMessageService;

    @GetMapping(value = "for/user", produces = "application/json")
    public ResponseEntity<List<Chat>> getChatList() throws IllegalAccessException {
        return new ResponseEntity<>(chatMessageService.getChatMessageForUser(), HttpStatus.OK);
    }

}
