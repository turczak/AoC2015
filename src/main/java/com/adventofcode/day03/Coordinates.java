package com.adventofcode.day03;

public record Coordinates(int x, int y) {

    public Coordinates withX(int x) {
        return new Coordinates(x, y);
    }

    public Coordinates withY(int y) {
        return new Coordinates(x, y);
    }
}
