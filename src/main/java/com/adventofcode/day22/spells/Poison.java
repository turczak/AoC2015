package com.adventofcode.day22.spells;

import com.adventofcode.day22.Boss;
import com.adventofcode.day22.Effect;
import com.adventofcode.day22.Player;
import com.adventofcode.day22.Spell;
import com.adventofcode.day22.spells.effects.PoisonEffect;

import java.util.List;

public class Poison extends Spell {

    public Poison() {
        super("Poison", 173);
    }

    @Override
    public void cast(Player player, Boss boss, List<Effect> effects) {
        player.spendMana(cost);
        boss.getActiveEffects().add(new PoisonEffect());
    }

}
