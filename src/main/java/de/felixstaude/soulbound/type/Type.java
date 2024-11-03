package de.felixstaude.soulbound.type;

import de.felixstaude.soulbound.attack.Attack;
import de.felixstaude.soulbound.card.Card;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;
import jakarta.persistence.ManyToMany;

/**
 * Represents a Type that can be associated with both Cards and Attacks.
 * For example, a type could be "Fire", "Water", or "Ground".
 */
@Entity
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // The name of the type, e.g., fire, water, ground

    /**
     * A list of cards associated with this type.
     * For example, a card can have multiple types like "Fire" and "Flying".
     */
    @ManyToMany(mappedBy = "types")
    private List<Card> cards;

    /**
     * A list of attacks associated with this type.
     * For example, an attack can have a type like "Water" which indicates that it is a water-based attack.
     */
    @ManyToMany(mappedBy = "types")
    private List<Attack> attacks;

    // Getter and Setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<Attack> attacks) {
        this.attacks = attacks;
    }
}
