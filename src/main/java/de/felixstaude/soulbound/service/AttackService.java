package de.felixstaude.soulbound.service;

import de.felixstaude.soulbound.attack.Attack;
import de.felixstaude.soulbound.repository.AttackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Attack entities.
 * Provides methods to handle CRUD operations and business logic related to Attack objects.
 */
@Service
public class AttackService {

    private final AttackRepository attackRepository;

    /**
     * Constructor-based dependency injection of AttackRepository.
     * @param attackRepository Repository for Attack entities.
     */
    @Autowired
    public AttackService(AttackRepository attackRepository) {
        this.attackRepository = attackRepository;
    }

    /**
     * Creates or updates an Attack entity in the database.
     * @param attack The Attack entity to be saved.
     * @return The saved Attack entity.
     */
    public Attack createAttack(Attack attack) {
        return attackRepository.save(attack);
    }

    /**
     * Retrieves an Attack entity by its ID.
     * @param id The ID of the Attack entity.
     * @return An Optional containing the Attack entity if found, or empty if not.
     */
    public Optional<Attack> getAttackById(Long id) {
        return attackRepository.findById(id);
    }

    /**
     * Retrieves all Attack entities from the database.
     * @return A list of all Attack entities.
     */
    public List<Attack> getAllAttacks() {
        return attackRepository.findAll();
    }

    /**
     * Deletes an Attack entity by its ID.
     * @param id The ID of the Attack entity to be deleted.
     */
    public void deleteAttack(Long id) {
        attackRepository.deleteById(id);
    }
}
