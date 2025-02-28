package com.adventofcode.day03;

import java.util.HashMap;
import java.util.List;

public class Day03 {

    public int deliverYourself(List<Character> instructions) {
        HashMap<Coordinates, Integer> visitedHouses = new HashMap<>();
        Coordinates coords = new Coordinates(0, 0);
        visitedHouses.put(coords, visitedHouses.getOrDefault(coords, 0) + 1);
        for (char direction : instructions) {
            coords = move(coords, direction);
            visitedHouses.put(coords, visitedHouses.getOrDefault(coords, 0) + 1);
        }
        return visitedHouses.size();
    }

    public int deliverWithRobo(List<Character> instructions) {
        HashMap<Coordinates, Integer> visitedHouses = new HashMap<>();
        boolean santaTurn = true;
        Coordinates santaCoords = new Coordinates(0, 0);
        Coordinates roboSantaCoords = new Coordinates(0, 0);
        for (char direction : instructions) {
            if (santaTurn) {
                santaCoords = move(santaCoords, direction);
                visitedHouses.put(santaCoords, visitedHouses.getOrDefault(santaCoords, 0) + 1);
            } else {
                roboSantaCoords = move(roboSantaCoords, direction);
                visitedHouses.put(roboSantaCoords, visitedHouses.getOrDefault(roboSantaCoords, 0) + 1);
            }
            santaTurn = !santaTurn;
        }
        return visitedHouses.size();
    }

    private Coordinates move(Coordinates coords, char direction) {
        return switch (direction) {
            case '>' -> coords.withX(coords.x() + 1);
            case '<' -> coords.withX(coords.x() - 1);
            case '^' -> coords.withY(coords.y() + 1);
            case 'v' -> coords.withY(coords.y() - 1);
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        };
    }
}
