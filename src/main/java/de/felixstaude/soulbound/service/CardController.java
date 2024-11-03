package de.felixstaude.soulbound.service;

import de.felixstaude.soulbound.card.Card;
import de.felixstaude.soulbound.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Card entities.
 * This controller provides endpoints to handle CRUD operations for cards.
 */
@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    /**
     * Constructor-based dependency injection of CardService.
     * @param cardService The service layer that handles business logic for cards.
     */
    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    /**
     * Creates a new Card entity.
     * @param card The Card object to be created.
     * @return The newly created Card object.
     */
    @PostMapping
    public Card createCard(@RequestBody Card card) {
        return cardService.createCard(card);
    }

    /**
     * Retrieves a Card entity by its ID.
     * @param id The ID of the Card to retrieve.
     * @return An Optional containing the Card if found, or empty if not.
     */
    @GetMapping("/{id}")
    public Optional<Card> getCardById(@PathVariable Long id) {
        return cardService.getCardById(id);
    }

    /**
     * Retrieves all Card entities.
     * @return A list of all Cards.
     */
    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    /**
     * Updates an existing Card entity by its ID.
     * @param id The ID of the Card to update.
     * @param updatedCard The updated Card object with new details.
     * @return The updated Card object.
     */
    @PutMapping("/{id}")
    public Card updateCard(@PathVariable Long id, @RequestBody Card updatedCard) {
        return cardService.updateCard(id, updatedCard);
    }

    /**
     * Deletes a Card entity by its ID.
     * @param id The ID of the Card to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
    }
}
