package com.adventofcode.day21;

public class LivingEntity {

    private int hitPoints;
    private final int damage;
    private final int defense;

    public LivingEntity(int hitPoints, int damage, int defense) {
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.defense = defense;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public void takeDamage(int damageAmount) {
        hitPoints -= damageAmount;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }
    
}
