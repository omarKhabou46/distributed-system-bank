# bank-service

Description

Service gérant les comptes bancaires : création de comptes, récupération de comptes et intégration avec le service client.

Fonctionnalités principales

- POST /api/bank-account-service  — créer un compte bancaire (corps: BankAccount JSON).
- GET /api/bank-account-service/accounts — récupérer la liste des comptes (renvoie des DTO BankAccountDTOResponse).
- GET /api/bank-account-service/account/{id} — récupérer un compte par son identifiant.
- Communication avec customer-service via Feign client (CustomerClient) pour récupérer les informations clients.
- Résilience: circuit breaker (Resilience4j) avec fallback pour les appels au service client.
- Gestion globale des exceptions via GlobalExceptionHandler.

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

- SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/bankdb
- SPRING_DATASOURCE_USERNAME=user
- SPRING_DATASOURCE_PASSWORD=pass
- SERVER_PORT=8081

Notes pour les développeurs

- Vérifier le mapping des DTO (BankAccountDTOResponse) et la validation des entrées.
- Adapter les paramètres de circuit breaker/resilience selon l'environnement.

<img width="308" height="228" alt="image" src="https://github.com/user-attachments/assets/402a0ad4-8fb8-4906-92fa-90c66e001b08" />

