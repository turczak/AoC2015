package com.adventofcode.day22.spells;

import com.adventofcode.day22.Boss;
import com.adventofcode.day22.Effect;
import com.adventofcode.day22.Player;
import com.adventofcode.day22.Spell;

import java.util.List;

public class MagicMissile extends Spell {

    private static final int DAMAGE_AMOUNT = 4;

    public MagicMissile() {
        super("Magic Missile", 53);
    }

    @Override
    public void cast(Player player, Boss boss, List<Effect> effects) {
        player.spendMana(cost);
        boss.takeDamage(DAMAGE_AMOUNT);
    }

}
