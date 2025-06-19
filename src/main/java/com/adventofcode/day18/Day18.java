package com.adventofcode.day18;

import com.adventofcode.day06.Light;

import java.util.ArrayList;
import java.util.List;

public class Day18 {

    private static final int GRID_SIZE = 100;
    private final int steps;
    private final List<List<Light>> lights;

    public Day18(List<String> input, int steps) {
        this.steps = steps;
        lights = parseToGrid(input);
    }

    public long solvePartI() {
        List<List<Light>> newLights = lights;
        for (int i = 0; i < steps; i++) {
            newLights = makeStep(newLights);
        }
        return countLights(newLights);
    }

    public long solvePartII() {
        List<List<Light>> newLights = lights;
        for (int i = 0; i < steps; i++) {
            newLights = makeStepII(newLights);
        }
        return countLights(newLights);
    }

    private long countLights(List<List<Light>> lights) {
        return lights.stream()
                .flatMap(List::stream)
                .filter(Light::state)
                .count();
    }

    private List<List<Light>> parseToGrid(List<String> input) {
        return input.stream()
                .map(line -> line.chars()
                        .mapToObj(character -> new Light(character == '#', 0))
                        .toList())
                .toList();
    }

    private int countNeighbors(List<List<Light>> lights, int x, int y) {
        int neighbors = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int neighborX = x + i;
                int neighborY = y + j;
                if ((i != 0 || j != 0) && // ignore my position
                        neighborX >= 0 && neighborX < GRID_SIZE && // check borders
                        neighborY >= 0 && neighborY < GRID_SIZE && // check borders
                        lights.get(neighborX).get(neighborY).state()) {
                    neighbors++;
                }
            }
        }
        return neighbors;
    }

    private List<List<Light>> makeStep(List<List<Light>> lights) {
        List<List<Light>> changedLights = new ArrayList<>(GRID_SIZE);
        for (int x = 0; x < GRID_SIZE; x++) {
            List<Light> row = new ArrayList<>(GRID_SIZE);
            for (int y = 0; y < GRID_SIZE; y++) {
                int neighbors = countNeighbors(lights, x, y);
                boolean nextState = lights.get(x).get(y).state()
                        ? (neighbors == 2 || neighbors == 3)
                        : (neighbors == 3);
                row.add(lights.get(x).get(y).withState(nextState).withState(nextState));
            }
            changedLights.add(row);
        }
        return changedLights;
    }

    private List<List<Light>> makeStepII(List<List<Light>> lights) { // all corners are always lit
        List<List<Light>> changedLights = new ArrayList<>(GRID_SIZE);
        for (int x = 0; x < GRID_SIZE; x++) {
            List<Light> row = new ArrayList<>(GRID_SIZE);
            for (int y = 0; y < GRID_SIZE; y++) {
                boolean isCorner = (x == 0 || x == GRID_SIZE - 1) &&
                        (y == 0 || y == GRID_SIZE - 1);
                if (isCorner) {
                    row.add(new Light(true, 0));
                } else {
                    int neighbors = countNeighbors(lights, x, y);
                    boolean nextState = lights.get(x).get(y).state()
                            ? (neighbors == 2 || neighbors == 3)
                            : (neighbors == 3);
                    row.add(lights.get(x).get(y).withState(nextState).withState(nextState));
                }
            }
            changedLights.add(row);
        }
        return changedLights;
    }
}
