# chatbot-service

Description

Service de chat (chatbot) faisant partie du projet bank-micro-service. Fournit des endpoints pour l'interaction conversationnelle et l'orchestration des dialogues.

Prérequis

- Java 17+ (ou version requise par le projet)
- Maven
- Docker (optionnel)

Installation & compilation

```bash
mvn clean package
```

Lancer en local

- Avec Maven :
  ```bash
  mvn spring-boot:run
  ```
- Ou exécuter le JAR produit :
  ```bash
  java -jar target/*.jar
  ```

Variables d'environnement

- EXAMPLE_ENV=valeur  # ajouter les variables réelles ici

Endpoints (exemples)

- POST /api/chat/message  — envoyer un message au chatbot

Tests

```bash
mvn test
```

Docker

```bash
docker build -t chatbot-service:latest .
docker run -e EXAMPLE_ENV=valeur -p 8080:8080 chatbot-service:latest
```

Contribution

Merci d'ouvrir une MR pour toute amélioration. Décrire les changements et ajouter des tests lorsque possible.

Licence

Voir la racine du dépôt pour les informations de licence.

TODO

- Compléter les variables d'environnement et les endpoints réels.
