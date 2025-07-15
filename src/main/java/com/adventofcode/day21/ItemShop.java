package com.adventofcode.day21;

import java.util.Set;

public class ItemShop {

    private final Set<Weapon> weapons = initializeWeapons();
    private final Set<Armor> armors = initializeArmors();
    private final Set<Ring> rings = initializeRings();

    private Set<Weapon> initializeWeapons() {
        return Set.of(
                new Weapon("Dagger", 8, 4),
                new Weapon("Shortsword", 10, 5),
                new Weapon("Warhammer", 25, 6),
                new Weapon("Longsword", 40, 7),
                new Weapon("Greataxe", 74, 8)
        );
    }

    private Set<Armor> initializeArmors() {
        return Set.of(
                new Armor("No armor", 0, 0),
                new Armor("Leather", 13, 1),
                new Armor("Chainmail", 31, 2),
                new Armor("Splintmail", 53, 3),
                new Armor("Bandedmail", 75, 4),
                new Armor("Platemail", 102, 5)
        );
    }

    private Set<Ring> initializeRings() {
        return Set.of(
                new Ring("Damage +1", 25, 1, 0),
                new Ring("Damage +2", 50, 2, 0),
                new Ring("Damage +3", 100, 3, 0),
                new Ring("Defense +1", 20, 0, 1),
                new Ring("Defense +2", 40, 0, 2),
                new Ring("Defense +3", 80, 0, 3)
        );
    }

    public Set<Weapon> getWeapons() {
        return weapons;
    }

    public Set<Armor> getArmors() {
        return armors;
    }

    public Set<Ring> getRings() {
        return rings;
    }

}
