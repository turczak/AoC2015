package com.adventofcode.day21;

public class ItemFromShop {

    private final String name;
    private final int cost;

    public ItemFromShop(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
    
}
