package com.enset.chatbotservice;


import org.springframework.ai.chat.client.ChatClient;

public class ChatBot {
   private final ChatClient chatClient;

    public ChatBot(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    public String chat(String message) {
        return chatClient
                .prompt()
                .user(message)
                .call()
                .content();
    }
}
