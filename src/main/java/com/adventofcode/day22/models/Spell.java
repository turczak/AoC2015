package com.adventofcode.day22.models;

public abstract class Spell {

    protected final String name;
    protected final int cost;

    public Spell(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public abstract void cast(Player player, Boss boss);

}
