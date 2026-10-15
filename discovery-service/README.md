# discovery-service

Description

Serveur de découverte basé sur Eureka (@EnableEurekaServer). Permet l'enregistrement et la découverte des microservices du système.

Fonctionnalités principales

- Fournit un annuaire Eureka pour que les services (customer-service, bank-service, gateway, ...) s'enregistrent et se découvrent.
- Interface d'administration Eureka (par défaut sur /) pour visualiser les instances enregistrées.

Prérequis

- Java 17+
- Maven

Compilation et exécution

```bash
mvn clean package
mvn spring-boot:run
# ou
java -jar target/*.jar
```

Configuration

- Port par défaut typique : 8761 (configurable via application.properties/yml).

Docker

```bash
docker build -t discovery-service:latest .
docker run -p 8761:8761 discovery-service:latest
```

Notes

- Assurer que les autres services pointent vers ce serveur via eureka.client.serviceUrl.defaultZone.
- Sécuriser l'accès si nécessaire pour la production.
