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

Notes

- Assurer que les autres services pointent vers ce serveur via eureka.client.serviceUrl.defaultZone.
- Sécuriser l'accès si nécessaire pour la production.
<img width="1841" height="959" alt="image" src="https://github.com/user-attachments/assets/b52eccf5-36ee-45a5-88db-dc486f92a06f" />
