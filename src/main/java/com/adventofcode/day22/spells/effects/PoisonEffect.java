package com.adventofcode.day22.spells.effects;

import com.adventofcode.day22.Boss;
import com.adventofcode.day22.Effect;
import com.adventofcode.day22.Player;

public class PoisonEffect extends Effect {

    private static final int DAMAGE_AMOUNT = 3;

    public PoisonEffect() {
        super("Poison", 6);
    }

    @Override
    public void apply(Player player, Boss boss) {
        boss.takeDamage(DAMAGE_AMOUNT);
    }

    @Override
    public void onEnd(Player player, Boss boss) {
        // no effect
    }

}
