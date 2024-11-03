package de.felixstaude.soulbound.repository;

import de.felixstaude.soulbound.type.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
/**
 * Repository interface for Type entity.
 * Extends JpaRepository to provide CRUD operations and database interaction for Type entities.
 * No need to implement methods, as JpaRepository provides built-in implementations for common operations.
 */

public interface TypeRepository extends JpaRepository<Type, Long> {

    // Existing method to find type by name
    Optional<Type> findByName(String name);

    // New method to check if a type with the given name exists
    boolean existsByName(String name);
}


