package com.adventofcode.day21;

public class Ring extends ItemFromShop {

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
    
}
