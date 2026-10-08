package com.enset.chatbotservice.controller;

import com.enset.chatbotservice.service.ChatBotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat-service")
@RequiredArgsConstructor
public class ChatBotController {

    private final ChatBotService chatBotService;

    @GetMapping
    public ResponseEntity<String> chat(@RequestParam String message) {
        return new ResponseEntity<>(chatBotService.chat(message), HttpStatus.OK);
    }

}
