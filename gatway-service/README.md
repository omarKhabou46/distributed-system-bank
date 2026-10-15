# gatway-service

Description

Service de gateway (passerelle) gérant le routage des requêtes vers les différents services du projet bank-micro-service.

Prérequis

- Java 17+
- Maven

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

- ROUTING_CONFIG=...
- SERVER_PORT=8080

Endpoints principaux

- /actuator/**
- Routes configurées via la configuration (application.yml/properties)

Tests

```bash
mvn test
```

Docker

```bash
docker build -t gatway-service:latest .
docker run -p 8080:8080 gatway-service:latest
```

Contribution

Ouvrir une MR et documenter les modifications de routage.

Licence

Voir la racine du dépôt.

TODO

- Corriger le nom si nécessaire (gateway vs gatway) et compléter les routes.
