package com.adventofcode.day22.spells.effects;

import com.adventofcode.day22.Boss;
import com.adventofcode.day22.Effect;
import com.adventofcode.day22.Player;

public class RechargeEffect extends Effect {

    private static final int MANA_AMOUNT = 101;

    public RechargeEffect() {
        super("Recharge", 5);
    }

    @Override
    public void apply(Player player, Boss boss) {
        player.regenerateMana(MANA_AMOUNT);
    }

    @Override
    public void onEnd(Player player, Boss boss) {
        // no effect
    }

}
