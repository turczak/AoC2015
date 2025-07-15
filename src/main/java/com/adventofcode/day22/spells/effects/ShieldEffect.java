package com.adventofcode.day22.spells.effects;

import com.adventofcode.day22.Boss;
import com.adventofcode.day22.Effect;
import com.adventofcode.day22.Player;

public class ShieldEffect extends Effect {

    private static final int DEFENSE_AMOUNT = 7;

    public ShieldEffect() {
        super("Shield", 6);
    }

    @Override
    public void apply(Player player, Boss boss) {
        if (timer == 6) {
            player.setDefense(player.getDefense() + DEFENSE_AMOUNT);
        }
    }

    @Override
    public void onEnd(Player player, Boss boss) {
        player.setDefense(player.getDefense() - DEFENSE_AMOUNT);
    }

}
