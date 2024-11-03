package de.felixstaude.soulbound.card;

import de.felixstaude.soulbound.attack.Attack;
import de.felixstaude.soulbound.type.Type;
import jakarta.persistence.*;
import java.util.List;

/**
 * Represents a card in the Soulbound game.
 * Each card has attributes like name, health, description, card set, evolution stage, and relationships with attacks and types.
 */
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // The name of the card
    private int health; // The health points of the card
    private String description; // A description of the card
    private String cardSet; // The set to which the card belongs, e.g., a year or theme set
    private int stage; // The stage of evolution of the card (e.g., basic, stage 1, stage 2)

    /**
     * Many-to-one relationship indicating that this card can have a previous stage (evolution).
     * For example, a card can evolve from a previous version of itself.
     */
    @ManyToOne
    @JoinColumn(name = "previous_stage_id")
    private Card previousStage;

    /**
     * Many-to-many relationship with Attack, allowing each card to have multiple attacks.
     * This means that an attack can be shared across multiple cards.
     */
    @ManyToMany
    @JoinTable(
            name = "card_attack",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "attack_id")
    )
    private List<Attack> attacks;

    /**
     * Many-to-many relationship with Type, allowing each card to have multiple types.
     * For example, a card can be of type "Fire" and "Flying".
     */
    @ManyToMany
    @JoinTable(
            name = "card_type",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    private List<Type> types;

    // Getter and setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for health value of the card
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    // Getter and setter for description of the card
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and setter for the set to which the card belongs
    public String getCardSet() {
        return cardSet;
    }

    public void setCardSet(String cardSet) {
        this.cardSet = cardSet;
    }

    // Getter and setter for the evolution stage of the card
    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    // Getter and setter for the previous stage card (evolution)
    public Card getPreviousStage() {
        return previousStage;
    }

    public void setPreviousStage(Card previousStage) {
        this.previousStage = previousStage;
    }

    // Getter and setter for the list of attacks associated with this card
    public List<Attack> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<Attack> attacks) {
        this.attacks = attacks;
    }

    // Getter and setter for the list of types associated with this card
    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }
}
