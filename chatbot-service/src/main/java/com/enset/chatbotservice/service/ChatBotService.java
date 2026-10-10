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
                        You are a helpful assistant.
                        Use available tools to answer questions and perform requested operations.
                        When the user asks to create a customer, call the appropriate tool.
                        Extract the customer's name and email from the user's message.
                        If required information is missing, ask the user for clarification.
                        Never claim an operation succeeded unless the tool confirms it.
                        If the request is outside your scope, answer: "I don't know."
                        Respond in the same language as the user.""")
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
