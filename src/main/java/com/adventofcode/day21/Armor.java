package com.adventofcode.day21;

public class Armor extends ItemFromShop {

    private final int defense;

    public Armor(String name, int cost, int defense) {
        super(name, cost);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }
    
}
