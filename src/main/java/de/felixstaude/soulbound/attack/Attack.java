package de.felixstaude.soulbound.attack;

import de.felixstaude.soulbound.card.Card;
import de.felixstaude.soulbound.type.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Represents an attack that a card can use in the Soulbound game.
 * Each attack has a name, damage value, and is associated with multiple types.
 * It can also belong to a specific card.
 */
@Setter
@Getter
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
    @ManyToOne(cascade = CascadeType.PERSIST)
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

}