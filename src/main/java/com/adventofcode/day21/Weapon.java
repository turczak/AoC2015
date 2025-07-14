package com.adventofcode.day21;

public class Weapon extends ItemFromShop {

    private final int damage;

    public Weapon(String name, int cost, int damage) {
        super(name, cost);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
    
}
