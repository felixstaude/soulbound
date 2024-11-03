package de.felixstaude.soulbound.service;

import de.felixstaude.soulbound.card.Card;
import de.felixstaude.soulbound.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for handling business logic related to Card entities.
 * This service interacts with the CardRepository for database operations.
 */
@Service
public class CardService {

    private final CardRepository cardRepository;

    /**
     * Constructor-based dependency injection of CardRepository.
     * @param cardRepository The repository layer that handles database interactions for cards.
     */
    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    /**
     * Creates a new Card entity.
     * @param card The Card object to be created.
     * @return The newly created Card object.
     */
    public Card createCard(Card card) {
        return cardRepository.save(card);
    }

    /**
     * Retrieves a Card entity by its ID.
     * @param id The ID of the Card to retrieve.
     * @return An Optional containing the Card if found, or empty if not.
     */
    public Optional<Card> getCardById(Long id) {
        return cardRepository.findById(id);
    }

    /**
     * Retrieves all Card entities.
     * @return A list of all Cards.
     */
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    /**
     * Updates an existing Card entity by its ID.
     * @param id The ID of the Card to update.
     * @param updatedCard The updated Card object with new details.
     * @return The updated Card object, or null if the Card with the given ID does not exist.
     */
    public Card updateCard(Long id, Card updatedCard) {
        if (cardRepository.existsById(id)) {
            updatedCard.setId(id); // Ensure the correct ID is set for the update
            return cardRepository.save(updatedCard);
        }
        return null; // Return null if the Card does not exist
    }

    /**
     * Deletes a Card entity by its ID.
     * @param id The ID of the Card to delete.
     */
    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }
}