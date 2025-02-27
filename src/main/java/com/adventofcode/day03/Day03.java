package com.adventofcode.day03;

import java.util.HashMap;
import java.util.List;

public class Day03 {

    private final HashMap<Coordinates, Integer> visitedHouses = new HashMap<>();

    public int deliverPresents(List<Character> instructions) {
        Coordinates coords = new Coordinates(0, 0);
        //Santa begins by delivering a present to the house at his starting location
        visitedHouses.put(coords, visitedHouses.getOrDefault(coords, 0) + 1);
        for (char direction : instructions) {
            coords = move(coords, direction);
            visitedHouses.put(coords, visitedHouses.getOrDefault(coords, 0) + 1);
        }
        return this.visitedHouses.size();
    }

    private Coordinates move(Coordinates coords, char direction) {
        return switch (direction) {
            case '>' -> new Coordinates(coords.x() + 1, coords.y());
            case '<' -> new Coordinates(coords.x() - 1, coords.y());
            case '^' -> new Coordinates(coords.x(), coords.y() + 1);
            case 'v' -> new Coordinates(coords.x(), coords.y() - 1);
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        };
    }
}
