package com.enset.chatbotservice.service;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

@Service
public class ChatBotService {
   private final ChatClient chatClient;

    public ChatBotService(ChatClient.Builder chatClient, ChatMemory chatMemory, ToolCallbackProvider toolCallbackProvider) {
        this.chatClient = chatClient
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .defaultTools(toolCallbackProvider)
                .defaultSystem("""
                        vous etes un agent dans une banque
                        """)
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
