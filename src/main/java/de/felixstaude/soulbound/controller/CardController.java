package de.felixstaude.soulbound.controller;

import de.felixstaude.soulbound.card.Card;
import de.felixstaude.soulbound.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
        Card createdCard = cardService.createCard(card);
        return ResponseEntity.ok(createdCard);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable Long id) {
        Optional<Card> card = cardService.getCardById(id);
        return card.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Card>> getAllCards() {
        return ResponseEntity.ok(cardService.getAllCards());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCard(@PathVariable Long id, @RequestBody Card updatedCard) {
        Card card = cardService.updateCard(id, updatedCard);
        if (card != null) {
            return ResponseEntity.ok(card);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
        return ResponseEntity.ok().build();
    }
}
