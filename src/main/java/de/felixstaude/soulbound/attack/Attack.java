package de.felixstaude.soulbound.attack;

import de.felixstaude.soulbound.card.Card;
import de.felixstaude.soulbound.type.Type;
import jakarta.persistence.*;
import java.util.List;

/**
 * Represents an attack that a card can use in the Soulbound game.
 * Each attack has a name, damage value, and is associated with multiple types.
 * It can also belong to a specific card.
 */
@Entity
public class Attack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // The name of the attack
    private int damage; // The damage value that the attack can deal

    /**
     * Many-to-one relationship indicating that each attack can belong to a specific card.
     * This allows associating an attack with a particular card.
     */
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    /**
     * Many-to-many relationship with Type, as each attack can have multiple types.
     * For example, an attack can be of type "Fire" or "Water".
     */
    @ManyToMany
    @JoinTable(
            name = "attack_type",
            joinColumns = @JoinColumn(name = "attack_id"),
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

    // Getter and setter for damage value of the attack
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    // Getter and setter for the associated Card
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    // Getter and setter for the list of types associated with this attack
    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }
}
