package com.adventofcode.day22.spells;

import com.adventofcode.day22.models.Boss;
import com.adventofcode.day22.models.Effect;
import com.adventofcode.day22.models.Player;
import com.adventofcode.day22.models.SpellWithEffect;
import com.adventofcode.day22.spells.effects.PoisonEffect;

public class Poison extends SpellWithEffect {

    public Poison() {
        super("Poison", 173);
    }

    @Override
    public void cast(Player player, Boss boss) {
        boss.getActiveEffects().add(createEffect());
    }

    @Override
    public Effect createEffect() {
        return new PoisonEffect();
    }

}
