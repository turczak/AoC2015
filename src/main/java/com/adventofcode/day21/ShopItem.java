package com.adventofcode.day21;

import java.util.Objects;

public class ShopItem {

    private final String name;
    private final int cost;

    public ShopItem(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null
                || getClass() != object.getClass()) {
            return false;
        }
        ShopItem shopItem = (ShopItem) object;
        return cost == shopItem.cost
                && Objects.equals(name, shopItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost);
    }

    @Override
    public String toString() {
        return String.format("%s (cost= %d", getName(), getCost());
    }
    
}
