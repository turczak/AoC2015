package com.adventofcode.day22.spells;

import com.adventofcode.day22.models.Boss;
import com.adventofcode.day22.models.Player;
import com.adventofcode.day22.models.Spell;

public class MagicMissile extends Spell {

    private static final int DAMAGE_AMOUNT = 4;

    public MagicMissile() {
        super("Magic Missile", 53);
    }

    @Override
    public void cast(Player player, Boss boss) {
        boss.takeDamage(DAMAGE_AMOUNT);
    }

}
