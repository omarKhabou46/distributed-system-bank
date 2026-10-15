# customer-service

Description

Service gérant les informations clients (CRUD) pour le projet bank-micro-service.

Prérequis

- Java 17+
- Maven
- Base de données (ex : PostgreSQL)

Installation & compilation

```bash
mvn clean package
```

Lancer en local

```bash
mvn spring-boot:run
# ou
java -jar target/*.jar
```

Variables d'environnement (exemples)

- SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/customers
- SPRING_DATASOURCE_USERNAME=user
- SPRING_DATASOURCE_PASSWORD=pass
- SERVER_PORT=8082

Endpoints (à compléter)

- GET /api/customers — lister les clients
- POST /api/customers — créer un client

Tests

```bash
mvn test
```

Docker

```bash
docker build -t customer-service:latest .
docker run -e SPRING_DATASOURCE_URL=... -p 8082:8082 customer-service:latest
```

Contribution

Merci de proposer des MR et d'ajouter des tests pour les nouvelles fonctionnalités.

Licence

Voir la racine du dépôt.

TODO

- Compléter les endpoints et exemples d'utilisation.
