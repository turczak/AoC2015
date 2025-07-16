package com.adventofcode.day22.spells;

import com.adventofcode.day22.models.Boss;
import com.adventofcode.day22.models.Effect;
import com.adventofcode.day22.models.Player;
import com.adventofcode.day22.models.SpellWithEffect;
import com.adventofcode.day22.spells.effects.RechargeEffect;

public class Recharge extends SpellWithEffect {

    public Recharge() {
        super("Recharge", 229);
    }

    @Override
    public void cast(Player player, Boss boss) {
        player.getActiveEffects().add(createEffect());
    }

    @Override
    public Effect createEffect() {
        return new RechargeEffect();
    }

}
