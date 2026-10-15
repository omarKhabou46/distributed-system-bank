# customer-service

Description

Service de gestion des clients (CRUD). Fournit des endpoints pour créer et consulter des clients et expose un client REST utilisé par d'autres services.

Fonctionnalités principales

- POST /api/customer-service  — créer un client (corps: CustomerRequestDTO).
- GET /api/customer-service/customers — lister tous les clients.
- GET /api/customer-service/customer/{id} — récupérer un client par son identifiant.
- Levée d'exception CustomerNotFoundException si le client n'existe pas (gérée par un GlobalExceptionHandler).

Prérequis

- Java 17+
- Maven
- Base de données (ex: PostgreSQL)

Compilation et exécution

```bash
mvn clean package
mvn spring-boot:run
# ou
java -jar target/*.jar
```

Configuration (variables courantes)

- SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/customers
- SPRING_DATASOURCE_USERNAME=user
- SPRING_DATASOURCE_PASSWORD=pass
- SERVER_PORT=8082

Notes pour les développeurs

- Vérifier la validation des données dans CustomerRequestDTO.
- Ajouter des tests d'intégration pour les cas d'erreur (client non trouvé).

<img width="447" height="256" alt="image" src="https://github.com/user-attachments/assets/bb7ed39f-cd70-425c-b375-edc610c98e06" />

