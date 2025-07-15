package com.adventofcode.day22;

import com.adventofcode.day21.LivingEntity;

public class Player extends LivingEntity {

    private int mana;

    public Player(int hitPoints, int damage, int defense, int mana) {
        super(hitPoints, damage, defense);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void spendMana(int amount) {
        mana -= amount;
    }

    public void regenerateMana(int amount) {
        mana += amount;
    }

}
