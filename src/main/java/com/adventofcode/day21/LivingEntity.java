package com.adventofcode.day21;

import com.adventofcode.day22.Effect;

import java.util.List;

public class LivingEntity {

    private final int damage;
    private int hitPoints;
    private int defense;
    private List<Effect> activeEffects;

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

    public void heal(int amount) {
        hitPoints += amount;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public List<Effect> getActiveEffects() {
        return activeEffects;
    }
    
}
