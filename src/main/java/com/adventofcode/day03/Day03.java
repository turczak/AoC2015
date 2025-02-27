package com.adventofcode.day03;

import java.awt.Point;
import java.util.HashMap;
import java.util.List;

public class Day03 {

    private final HashMap<Point, Integer> visitedHouses = new HashMap<>();
    private Point coords = new Point(0, 0);

    public int deliverPresents(List<Character> instructions) {
        //Santa begins by delivering a present to the house at his starting location
        visitedHouses.put(coords, visitedHouses.getOrDefault(coords, 0) + 1);
        for (char direction : instructions) {
            move(direction);
        }
        return this.visitedHouses.size();
    }

    private void move(char direction) {
        switch (direction) {
            case '>' -> coords = new Point(coords.x + 1, coords.y);
            case '<' -> coords = new Point(coords.x - 1, coords.y);
            case '^' -> coords = new Point(coords.x, coords.y + 1);
            case 'v' -> coords = new Point(coords.x, coords.y - 1);
        }
        visitedHouses.put(coords, visitedHouses.getOrDefault(coords, 0) + 1);
    }
}
