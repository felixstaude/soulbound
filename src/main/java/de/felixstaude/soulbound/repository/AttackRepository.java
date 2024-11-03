package de.felixstaude.soulbound.repository;

import de.felixstaude.soulbound.attack.Attack;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Attack entity.
 * Extends JpaRepository to provide CRUD operations and database interaction for Attack entities.
 * No need to implement methods, as JpaRepository provides built-in implementations for common operations.
 */
public interface AttackRepository extends JpaRepository<Attack, Long> {
    // JpaRepository provides common methods such as save(), findById(), findAll(), delete(), etc.
}
