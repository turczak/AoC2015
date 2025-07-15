package com.adventofcode.day21;

import java.util.Objects;

public class Weapon extends ShopItem {

    private final int damage;

    public Weapon(String name, int cost, int damage) {
        super(name, cost);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
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
        Weapon weapon = (Weapon) object;
        return damage == weapon.damage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                damage);
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format(", damage= %d)", damage);
    }

}
