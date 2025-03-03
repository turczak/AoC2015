package com.adventofcode.day06;

public record Light(boolean state, int brightness) {

    public Light() {
        this(false, 0);
    }

    public Light withState(boolean state) {
        return new Light(state, brightness);
    }

    public Light withBrightness(int brightness) {
        return new Light(state, brightness);
    }
}
