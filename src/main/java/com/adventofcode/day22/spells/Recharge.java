package com.adventofcode.day22.spells;

import com.adventofcode.day22.Boss;
import com.adventofcode.day22.Effect;
import com.adventofcode.day22.Player;
import com.adventofcode.day22.Spell;
import com.adventofcode.day22.spells.effects.RechargeEffect;

import java.util.List;

public class Recharge extends Spell {

    public Recharge() {
        super("Recharge", 229);
    }

    @Override
    public void cast(Player player, Boss boss, List<Effect> effects) {
        player.spendMana(cost);
        player.getActiveEffects().add(new RechargeEffect());
    }

}
