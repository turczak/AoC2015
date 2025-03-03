package com.adventofcode.day06;

public class Light {
    private boolean state;
    private int brightness;

    public Light() {
        this.state = false;
        this.brightness = 0;
    }

    public boolean getState() {
        return state;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }
}
