package com.adventofcode.day22.spells.effects;

import com.adventofcode.day22.models.Boss;
import com.adventofcode.day22.models.Effect;
import com.adventofcode.day22.models.Player;

public class ShieldEffect extends Effect {

    private static final int DEFENSE_BONUS = 7;
    private boolean applied = false;

    public ShieldEffect() {
        super("Shield", 6);
    }

    @Override
    public void apply(Player player, Boss boss) {
        if (!applied) {
            player.setDefense(player.getDefense() + DEFENSE_BONUS);
            applied = true;
        }
    }

    @Override
    public void onEnd(Player player, Boss boss) {
        player.setDefense(player.getDefense() - DEFENSE_BONUS);
    }

}
