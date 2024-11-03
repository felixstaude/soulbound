# Soulbound: A Web-Based Trading Card Game

## Overview

**Soulbound** is an online Trading Card Game (TCG) inspired by games like Pokémon but with unique features. Players can collect, battle, and trade **Soulbounds**, which are the creatures in the game. The goal of the project is to create an engaging and dynamic platform where players can strategize using different Soulbounds, each with its own types and attributes.

The project is being developed as a full-stack application, where the backend is implemented in Java, leveraging Spring Boot to manage business logic and database interactions. The frontend is developed using the Vue.js framework to create an interactive user experience.

## Table of Contents
- [Project Structure](#project-structure)
- [Documentation of Classes and Methods](#documentation-of-classes-and-methods)
    - [CardService](#cardservice)
    - [TypeService](#typeservice)
    - [AttackService](#attackservice)
    - [CardController](#cardcontroller)
    - [TypeController](#typecontroller)
    - [AttackController](#attackcontroller)
- [Security Configuration](#security-configuration)
- [Conclusion](#conclusion)
- [Directory Structure](#directory-structure)

## Project Structure

The project is split into several main components:

1. **Service Layer**: Handles the business logic of the application, including operations related to cards, types, and attacks.
2. **Controller Layer**: Exposes RESTful endpoints for operations related to cards, types, and attacks, making the backend accessible to the frontend.
3. **Repository Layer**: Provides direct access to the database, enabling operations like create, read, update, and delete (CRUD).
4. **Entities**: Represent the main domain objects such as cards, types, and attacks.

### Entities

1. **Card**: Represents a Soulbound card with attributes such as name, health, description, card set, evolution stage, and relationships with attacks and types.
2. **Type**: Represents the type of a Soulbound, such as "Fire" or "Water." Types define specific abilities and characteristics.
3. **Attack**: Represents an attack that a card can use, with attributes such as name, damage value, and associated types.

## Documentation of Classes and Methods

### CardService

The `CardService` class is responsible for managing all the business logic related to `Card` entities, including persistence, updates, and retrievals.

- **Dependencies**:

    - `CardRepository`: Interacts with the database for `Card` entities.
    - `TypeService`: Manages the persistence and retrieval of `Type` entities.

- **Methods**:

    - `createCard(Card card)`: Ensures that all types associated with the card are persisted, either by creating a new type or using an existing one. Once all dependencies are handled, it saves the card.
    - `getCardById(Long id)`: Retrieves a card based on its ID.
    - `getAllCards()`: Returns a list of all cards.
    - `updateCard(Long id, Card updatedCard)`: Updates the card information if the card exists in the database, ensuring that associated types are also persisted.
    - `deleteCard(Long id)`: Deletes a card by its ID.

### TypeService

The `TypeService` handles business logic related to `Type` entities.

- **Dependencies**:

    - `TypeRepository`: Interacts with the database for `Type` entities.

- **Methods**:

    - `createType(Type type)`: Creates a new type if it does not already exist.
    - `getOrCreateType(Type type)`: Checks whether a type with the given name exists in the database. If it exists, it returns the existing type. If not, it creates a new one.
    - `getAllTypes()`: Retrieves all types.
    - `typeExistsByName(String name)`: Checks if a type with the given name already exists in the database.

### AttackService

The `AttackService` class manages the business logic for `Attack` entities, including creating, updating, and retrieving attacks.

- **Dependencies**:

    - `AttackRepository`: Interacts with the database for `Attack` entities.

- **Methods**:

    - `createAttack(Attack attack)`: Saves a new attack to the database.
    - `getAttackById(Long id)`: Retrieves an attack based on its ID.
    - `getAllAttacks()`: Returns a list of all attacks.
    - `updateAttack(Long id, Attack updatedAttack)`: Updates an attack if it exists.
    - `deleteAttack(Long id)`: Deletes an attack by its ID.

### CardController

The `CardController` class is the REST controller that exposes endpoints for interacting with `Card` entities.

- **Endpoints**:
    - `POST /api/cards`: Creates a new card using `CardService`.
    - `GET /api/cards/{id}`: Retrieves a card by its ID.
    - `GET /api/cards`: Retrieves all cards.
    - `PUT /api/cards/{id}`: Updates an existing card.
    - `DELETE /api/cards/{id}`: Deletes a card by its ID.

### TypeController

The `TypeController` class is the REST controller that exposes endpoints for interacting with `Type` entities.

- **Endpoints**:
    - `POST /api/types`: Creates a new type if it does not already exist.
    - `GET /api/types/{id}`: Retrieves a type by its ID.
    - `GET /api/types`: Retrieves all types.

### AttackController

The `AttackController` class is the REST controller that exposes endpoints for interacting with `Attack` entities.

- **Endpoints**:
    - `POST /api/attacks`: Creates a new attack.
    - `GET /api/attacks/{id}`: Retrieves an attack by its ID.
    - `GET /api/attacks`: Retrieves all attacks.
    - `PUT /api/attacks/{id}`: Updates an existing attack.
    - `DELETE /api/attacks/{id}`: Deletes an attack by its ID.

## Security Configuration

The project includes a basic security configuration using Spring Security. The `SecurityConfig` class configures HTTP Basic Authentication for all endpoints and disables CSRF for simplicity during development. A default user is created in an in-memory user details manager for testing purposes.

## Conclusion

The **Soulbound** project aims to create a dynamic Trading Card Game experience with well-structured backend logic and an intuitive user interface. The backend services are built to handle complex relationships between cards, types, and attacks, ensuring that no duplicate entries are created and that data integrity is maintained. The controllers expose this functionality to the front end, providing a seamless and user-friendly interaction with the game data.

This documentation provides an overview of the classes, their purposes, and their interactions, forming a clear map of the project’s architecture and guiding further development.

## Directory Structure

The project's source code is organized as follows:

```
soulbound
│
├── src
│   └── main
│       └── java
│           └── de.felixstaude.soulbound
│               ├── attack
│               │   ├── Attack.java
│               ├── card
│               │   ├── Card.java
│               ├── config
│               │   ├── SecurityConfig.java
│               ├── controller
│               │   ├── AttackController.java
│               │   ├── CardController.java
│               │   ├── TypeController.java
│               ├── repository
│               │   ├── AttackRepository.java
│               │   ├── CardRepository.java
│               │   ├── TypeRepository.java
│               ├── service
│               │   ├── AttackService.java
│               │   ├── CardService.java
│               │   ├── TypeService.java
│               ├── type
│                   ├── Type.java
└── resources
    ├── static
    ├── templates
    └── application.properties
```

This directory structure provides a clear separation of concerns, making it easier to manage and extend the application.

