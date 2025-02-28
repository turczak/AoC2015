package com.adventofcode.day03;

import java.util.HashMap;
import java.util.List;

public class Day03 {

    private final HashMap<Coordinates, Integer> visitedHouses = new HashMap<>();

    public int deliverPresents(List<Character> instructions, WorkType workType) {
        Coordinates startingCoords = new Coordinates(0, 0);
        visitedHouses.clear();
        visitedHouses.put(startingCoords, visitedHouses.getOrDefault(startingCoords, 0) + (workType.equals(WorkType.SOLO) ? 1 : 2));
        return switch (workType) {
            case SOLO -> deliverYourself(instructions, startingCoords);
            case DUO -> deliverWithRobo(instructions, startingCoords);
        };
    }

    private int deliverYourself(List<Character> instructions, Coordinates coords) {
        for (char direction : instructions) {
            coords = move(coords, direction);
            visitedHouses.put(coords, visitedHouses.getOrDefault(coords, 0) + 1);
        }
        return visitedHouses.size();
    }

    private int deliverWithRobo(List<Character> instructions, Coordinates coords) {
        boolean isSantaTurn = true;
        Coordinates santaCoords = coords;
        Coordinates roboSantaCoords = coords;
        for (char direction : instructions) {
            if (isSantaTurn) {
                santaCoords = move(santaCoords, direction);
                visitedHouses.put(santaCoords, visitedHouses.getOrDefault(santaCoords, 0) + 1);
            } else {
                roboSantaCoords = move(roboSantaCoords, direction);
                visitedHouses.put(roboSantaCoords, visitedHouses.getOrDefault(roboSantaCoords, 0) + 1);
            }
            isSantaTurn = !isSantaTurn;
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
