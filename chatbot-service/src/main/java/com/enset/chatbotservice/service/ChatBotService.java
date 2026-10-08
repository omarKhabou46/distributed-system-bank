package com.enset.chatbotservice.service;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;

@Service
public class ChatBotService {
   private final ChatClient chatClient;

    public ChatBotService(ChatClient.Builder chatClient, ChatMemory chatMemory) {
        this.chatClient = chatClient
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }

    public String chat(String message, String conversationId) {
        return chatClient
                .prompt()
                .user(message)
                .advisors(advisor -> advisor.param(
                ChatMemory.CONVERSATION_ID,
                conversationId
                 ))
                .call()
                .content();
    }
}
