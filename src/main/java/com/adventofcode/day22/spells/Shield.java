package com.adventofcode.day22.spells;

import com.adventofcode.day22.Boss;
import com.adventofcode.day22.Effect;
import com.adventofcode.day22.Player;
import com.adventofcode.day22.Spell;
import com.adventofcode.day22.spells.effects.ShieldEffect;

import java.util.List;

public class Shield extends Spell {

    public Shield() {
        super("Shield", 113);
    }

    @Override
    public void cast(Player player, Boss boss, List<Effect> activeEffects) {
        player.spendMana(cost);
        player.getActiveEffects().add(new ShieldEffect());
    }

}
