package com.adventofcode.day22.spells;

import com.adventofcode.day22.models.Boss;
import com.adventofcode.day22.models.Effect;
import com.adventofcode.day22.models.Player;
import com.adventofcode.day22.models.SpellWithEffect;
import com.adventofcode.day22.spells.effects.ShieldEffect;

public class Shield extends SpellWithEffect {

    public Shield() {
        super("Shield", 113);
    }

    @Override
    public void cast(Player player, Boss boss) {
        player.getActiveEffects().add(createEffect());
    }

    @Override
    public Effect createEffect() {
        return new ShieldEffect();
    }

}
