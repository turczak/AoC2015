package com.adventofcode.day21;

import java.util.Objects;

public class Armor extends ShopItem {

    private final int defense;

    public Armor(String name, int cost, int defense) {
        super(name, cost);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null
                || getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        Armor armor = (Armor) object;
        return defense == armor.defense;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                defense);
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format(", defense= %d)", defense);
    }

}
