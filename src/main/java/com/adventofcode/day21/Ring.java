package com.adventofcode.day21;

import java.util.Objects;

public class Ring extends ShopItem {

    private final int damage;
    private final int defense;

    public Ring(String name, int cost, int damage, int defense) {
        super(name, cost);
        this.damage = damage;
        this.defense = defense;
    }

    public int getDamage() {
        return damage;
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
        Ring ring = (Ring) object;
        return damage == ring.damage
                && defense == ring.defense;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                damage,
                defense);
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format(", defense= %d, damage= %d)", defense, damage);
    }

}
