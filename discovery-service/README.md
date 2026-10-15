# discovery-service

Description

Service de découverte (ex : Eureka/Consul) permettant aux services du projet bank-micro-service de se découvrir mutuellement.

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

Configuration (exemples)

- SERVER_PORT=8761

Tests

```bash
mvn test
```

Docker

```bash
docker build -t discovery-service:latest .
docker run -p 8761:8761 discovery-service:latest
```

Contribution

Merci d'ouvrir des MR pour les améliorations ou corrections.

Licence

Voir la racine du dépôt.

TODO

- Préciser le mécanisme de découverte utilisé et l'URL d'administration.
