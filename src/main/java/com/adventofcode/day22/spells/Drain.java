package com.adventofcode.day22.spells;

import com.adventofcode.day22.Boss;
import com.adventofcode.day22.Effect;
import com.adventofcode.day22.Player;
import com.adventofcode.day22.Spell;

import java.util.List;

public class Drain extends Spell {

    private static final int DAMAGE_AMOUNT = 2;
    private static final int HEAL_AMOUNT = 2;

    public Drain() {
        super("Drain", 73);
    }

    @Override
    public void cast(Player player, Boss boss, List<Effect> activeEffects) {
        boss.takeDamage(DAMAGE_AMOUNT);
        player.heal(HEAL_AMOUNT);
    }

}
