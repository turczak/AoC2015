package com.adventofcode.day22.models;

public abstract class SpellWithEffect extends Spell {

    public SpellWithEffect(String name, int cost) {
        super(name, cost);
    }

    public abstract Effect createEffect();

}
