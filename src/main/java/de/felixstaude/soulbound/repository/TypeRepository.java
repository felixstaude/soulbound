package de.felixstaude.soulbound.repository;

import de.felixstaude.soulbound.type.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Type entity.
 * Extends JpaRepository to provide CRUD operations and database interaction for Type entities.
 * No need to implement methods, as JpaRepository provides built-in implementations for common operations.
 */
public interface TypeRepository extends JpaRepository<Type, Long> {
    // JpaRepository provides common methods such as save(), findById(), findAll(), delete(), etc.
}
