package com.ap.covid19.api.apcovid19.controllers;

import com.ap.covid19.api.apcovid19.models.Chat;
import com.ap.covid19.api.apcovid19.models.ChatMessages;
import com.ap.covid19.api.apcovid19.services.ChatMessageService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/v1/chat/messages")
@RestController
public class ChatMessagesController {

    private final ChatMessageService chatMessageService;

    @GetMapping(value = "for/user", produces = "application/json")
    @ApiOperation(value = "GET ALL CHAT MESSAGES FOR AUTHENTICATED USER")
    public ResponseEntity<List<Chat>> getChatList() throws IllegalAccessException {
        return new ResponseEntity<>(chatMessageService.getChatMessageForUser(), HttpStatus.OK);
    }

    @GetMapping(value = "by/id/{chatID}", produces = "application/json")
    @ApiOperation(value = "GET ALL CHAT MESSAGES BY CHAT ID")
    public ResponseEntity<List<ChatMessages>> getChatById(@PathVariable("chatID") Long chatID) {
        return new ResponseEntity<>(chatMessageService.getMessagesByChatID(chatID), HttpStatus.OK);
    }


    @GetMapping(value = "by/{to}/{from}", produces = "application/json")
    @ApiOperation(value = "GET ALL CHAT MESSAGES BY CHAT TO USER AND FROM USER")
    public ResponseEntity<Chat> getChatById(@PathVariable("to") Long to, @PathVariable("from") Long from) {
        return new ResponseEntity<>(chatMessageService.getMessagesByFromAndToUser(from, to), HttpStatus.OK);
    }


}
