package de.felixstaude.soulbound.service;

import de.felixstaude.soulbound.attack.Attack;
import de.felixstaude.soulbound.card.Card;
import de.felixstaude.soulbound.repository.AttackRepository;
import de.felixstaude.soulbound.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Attack entities.
 * Provides methods to handle CRUD operations and business logic related to Attack objects.
 */
@Service
public class AttackService {

    private final AttackRepository attackRepository;
    private final CardRepository cardRepository;

    // Constructor-based dependency injection of repositories
    @Autowired
    public AttackService(AttackRepository attackRepository, CardRepository cardRepository) {
        this.attackRepository = attackRepository;
        this.cardRepository = cardRepository;
    }

    /**
     * Creates or updates an Attack entity in the database.
     * @param attack The Attack entity to be saved.
     * @return The saved Attack entity.
     */
    @Transactional
    public Attack createAttack(Attack attack) {
        Card card = attack.getCard();

        // Explicitly save the Card entity first, if it is not already persisted
        if (card != null && card.getId() == null) {
            cardRepository.save(card);
        }

        // Now save the Attack entity
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