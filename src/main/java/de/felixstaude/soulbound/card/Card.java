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

    @ManyToOne
    @JoinColumn(name = "previous_stage_id")
    private Card previousStage;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "card_attack",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "attack_id")
    )
    private List<Attack> attacks;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "card_type",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    private List<Type> types;


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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCardSet() {
        return cardSet;
    }

    public void setCardSet(String cardSet) {
        this.cardSet = cardSet;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public Card getPreviousStage() {
        return previousStage;
    }

    public void setPreviousStage(Card previousStage) {
        this.previousStage = previousStage;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<Attack> attacks) {
        this.attacks = attacks;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }
}