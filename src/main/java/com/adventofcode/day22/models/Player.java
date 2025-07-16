package com.adventofcode.day22.models;

import com.adventofcode.day21.LivingEntity;
import com.adventofcode.day22.spells.Drain;
import com.adventofcode.day22.spells.MagicMissile;
import com.adventofcode.day22.spells.Poison;
import com.adventofcode.day22.spells.Recharge;
import com.adventofcode.day22.spells.Shield;

import java.util.HashSet;
import java.util.Set;

public class Player extends LivingEntity {

    private int mana;
    private final Set<Spell> spells = new HashSet<>(
            Set.of(
                    new MagicMissile(),
                    new Drain(),
                    new Shield(),
                    new Poison(),
                    new Recharge()
            )
    );

    public Player(int hitPoints, int damage, int defense, int mana) {
        super(hitPoints, damage, defense);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void spendMana(int amount) {
        mana -= amount;
    }

    public void regenerateMana(int amount) {
        mana += amount;
    }

    public Set<Spell> getSpells() {
        return spells;
    }

    public boolean canCastSpell(Spell spell, Boss boss) {
        if (mana < spell.getCost()) {
            return false;
        }
        if (spell instanceof SpellWithEffect spellWithEffect) {
            Effect effect = spellWithEffect.createEffect();
            boolean alreadyOnPlayer = this.getActiveEffects().stream()
                    .anyMatch(e -> e.getName().equals(effect.getName()));
            boolean alreadyOnBoss = boss.getActiveEffects().stream()
                    .anyMatch(e -> e.getName().equals(effect.getName()));
            return !alreadyOnPlayer && !alreadyOnBoss;
        }
        return true;
    }

    public void castSpell(Spell spell, Boss boss) {
        if (canCastSpell(spell, boss)) {
            spendMana(spell.getCost());
            spell.cast(this, boss);
        }
    }

}
