package de.felixstaude.soulbound.repository;

import de.felixstaude.soulbound.card.Card;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Card entity.
 * Extends JpaRepository to provide CRUD operations and database interaction for Card entities.
 * No need to implement methods, as JpaRepository provides built-in implementations for common operations.
 */
public interface CardRepository extends JpaRepository<Card, Long> {
    // JpaRepository provides common methods such as save(), findById(), findAll(), delete(), etc.
}
