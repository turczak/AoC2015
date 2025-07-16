package com.adventofcode.day22.models;

public abstract class Effect {

    protected final String name;
    protected int timer;

    public Effect(String name, int timer) {
        this.name = name;
        this.timer = timer;
    }

    public String getName() {
        return name;
    }

    public int getTimer() {
        return timer;
    }

    public void decreaseTimer() {
        timer--;
    }

    public abstract void apply(Player player, Boss boss);

    public abstract void onEnd(Player player, Boss boss);

}
