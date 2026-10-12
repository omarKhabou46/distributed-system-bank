//package com.enset.chatbotservice.discord;
//import com.enset.chatbotservice.service.ChatBotService;
//import com.zgamelogic.discord.annotations.DiscordController;
//import com.zgamelogic.discord.annotations.DiscordMapping;
//import lombok.RequiredArgsConstructor;
//import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
//
////@DiscordController
//@RequiredArgsConstructor
//public class DiscordBot {
//
//    private final ChatBotService chatBotService;
//
//    @DiscordMapping
//    public void perform(MessageReceivedEvent event) {
//
//        // Ignorer les messages envoyés par les bots
//        if (event.getAuthor().isBot()) {
//            return;
//        }
//
//        String query = event.getMessage().getContentRaw();
//
//        // Identifiant de conversation propre à chaque utilisateur
//        String conversationId = "discord-" + event.getAuthor().getId();
//
//        try {
//            String response = chatBotService.chat(query, conversationId);
//
//            if (response != null && !response.isBlank()) {
//                // Discord limite un message à 2000 caractères
//                String message = response.length() > 2000
//                        ? response.substring(0, 1997) + "..."
//                        : response;
//
//                event.getChannel().sendMessage(message).queue();
//            }
//        } catch (Exception e) {
//            event.getChannel()
//                    .sendMessage("Une erreur est survenue lors du traitement de votre demande.")
//                    .queue();
//
//            e.printStackTrace();
//        }
//    }
//}
