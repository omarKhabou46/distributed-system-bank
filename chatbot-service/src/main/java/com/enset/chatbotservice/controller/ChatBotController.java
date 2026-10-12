package com.enset.chatbotservice.controller;

import com.enset.chatbotservice.service.ChatBotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat-service")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ChatBotController {

    private final ChatBotService chatBotService;

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam String message, @RequestParam String conversationId) {
        return new ResponseEntity<>(chatBotService.chat(message, conversationId), HttpStatus.OK);
    }

}
