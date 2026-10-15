# bank-service

Description

Service central gérant la logique métier des comptes et opérations bancaires du projet bank-micro-service.

Prérequis

- Java 17+
- Maven
- Base de données (ex : PostgreSQL) si nécessaire

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

Configuration / Variables d'environnement (exemples)

- SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/bankdb
- SPRING_DATASOURCE_USERNAME=user
- SPRING_DATASOURCE_PASSWORD=pass
- SERVER_PORT=8081

Endpoints (à compléter)

- GET /api/accounts — lister les comptes
- POST /api/accounts — créer un compte

Tests

```bash
mvn test
```

Docker

```bash
docker build -t bank-service:latest .
docker run -e SPRING_DATASOURCE_URL=... -p 8081:8081 bank-service:latest
```

Contribution

Ouverture de MR, respecter les conventions de commits et ajouter des tests.

Licence

Voir la racine du dépôt.

TODO

- Vérifier et compléter les endpoints et variables d'environnement.
