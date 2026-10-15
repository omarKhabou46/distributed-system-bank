# gateway-service

Description

Passerelle API basée sur Spring Cloud Gateway. Utilise la découverte de services pour définir dynamiquement les routes vers les microservices enregistrés.

Fonctionnalités principales

- Routes dynamiques fournies par DiscoveryClientRouteDefinitionLocator (routes basées sur le Discovery Client).
- Exemple de routes (commentées dans application.yml) :
  - redirection de /api/customer-service/** vers customer-service
  - redirection de /api/bank-account-service/** vers bank-account-service
- Expose des endpoints d'actuator si activés (monitoring et santé).

Prérequis

- Java 17+
- Maven

Compilation et exécution

```bash
mvn clean package
mvn spring-boot:run
```

Configuration

- Les routes peuvent être définies dans application.yml ou automatiquement via le service de découverte.
- Vérifier les propriétés spring.cloud.gateway.discovery.locator si utilisées.

Notes

- Le nom du projet contient "gatway" dans le code; envisager de renommer en "gateway" pour cohérence.
- Assurer que le Discovery Server est accessible (Eureka) pour la résolution des routes.

## Utilisation de Routage static

```yaml
spring:
  cloud:
    gateway:
      server:
        webflux:
          routes:
            - id: customer-service
              uri: lb://customer-service
              predicates:
                - Path=/api/customer-service/**
            - id: bank-service
              uri: lb://bank-account-service
              predicates:
                - Path=/api/bank-account-service/**
```
