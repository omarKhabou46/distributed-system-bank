# chatbot-service

Description

Service chatbot fournissant des capacités de conversation et de streaming de réponses. Deux modes sont exposés :
- Chat synchrone : reçoit un message et renvoie une réponse texte.
- Chat en streaming (SSE) : renvoie un flux de réponses (text/event-stream) pour les longues réponses ou mises à jour progressives.

Fonctionnalités principales

- Endpoint GET /api/chat-service/chat?message={message}&conversationId={conversationId} — réponse texte synchrone.
- Endpoint GET /api/chat-service/chatStream?message={message}&conversationId={conversationId} — flux SSE de réponses.
- Gestion simple du contexte via conversationId.
- Intégration avec ChatBotService pour la génération de réponses.
- CORS activé pour permettre des appels depuis le front.

Prérequis

- Java 17+
- Maven
- Docker (optionnel)

Compilation et exécution

```bash
mvn clean package
mvn spring-boot:run
# ou
java -jar target/*.jar
```

Notes

- Ajuster le port et variables d'environnement selon la configuration.
- Compléter la documentation si des paramètres supplémentaires de la ChatBotService sont exposés.
