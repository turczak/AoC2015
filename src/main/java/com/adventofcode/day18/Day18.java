package com.adventofcode.day18;

import com.adventofcode.day06.Light;

import java.util.Arrays;
import java.util.List;

public class Day18 {

    private static final int GRID_SIZE = 100;
    private final int steps;
    private Light[][] lights = new Light[GRID_SIZE][GRID_SIZE];

    public Day18(List<String> input, int steps) {
        this.steps = steps;
        lights = parseToGrid(input);
    }

    public long solvePartI() {
        Light[][] newLights = lights;
        for (int i = 0; i < steps; i++) {
            newLights = makeStep(newLights);
        }
        return countLights(newLights);
    }

    public long solvePartII() {
        Light[][] newLights = lights;
        for (int i = 0; i < steps; i++) {
            newLights = makeStepII(newLights);
        }
        return countLights(newLights);
    }

    private long countLights(Light[][] lights) {
        return Arrays.stream(lights)
                .flatMap(Arrays::stream)
                .filter(Light::state)
                .count();
    }

    private Light[][] parseToGrid(List<String> input) {
        return input.stream()
                .map(line -> line.chars()
                        .mapToObj(character -> new Light(character == '#', 0))
                        .toArray(Light[]::new))
                .toArray(Light[][]::new);
    }

    private int countNeighbors(Light[][] lights, int x, int y) {
        int neighbors = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int neighborX = x + i;
                int neighborY = y + j;
                if ((i != 0 || j != 0) && // ignore my position
                        neighborX >= 0 && neighborX < GRID_SIZE && // check borders
                        neighborY >= 0 && neighborY < GRID_SIZE && // check borders
                        lights[neighborX][neighborY].state()) {
                    neighbors++;
                }
            }
        }
        return neighbors;
    }

    private Light[][] makeStep(Light[][] lights) {
        Light[][] changedLights = new Light[GRID_SIZE][GRID_SIZE];
        for (int x = 0; x < GRID_SIZE; x++) {
            for (int y = 0; y < GRID_SIZE; y++) {
                int neighbors = countNeighbors(lights, x, y);
                boolean nextState = lights[x][y].state()
                        ? (neighbors == 2 || neighbors == 3)
                        : (neighbors == 3);
                changedLights[x][y] = lights[x][y].withState(nextState);
            }
        }
        return changedLights;
    }

    private Light[][] makeStepII(Light[][] lights) { // all corners are always lit
        Light[][] changedLights = new Light[GRID_SIZE][GRID_SIZE];
        changedLights[0][0] = new Light(true, 0);
        changedLights[0][99] = new Light(true, 0);
        changedLights[99][0] = new Light(true, 0);
        changedLights[99][99] = new Light(true, 0);
        for (int x = 0; x < GRID_SIZE; x++) {
            for (int y = 0; y < GRID_SIZE; y++) {
                if ((x == 0 || x == 99) &&
                        (y == 0 || y == 99)) {
                    continue;
                }
                int neighbors = countNeighbors(lights, x, y);
                boolean nextState = lights[x][y].state()
                        ? (neighbors == 2 || neighbors == 3)
                        : (neighbors == 3);
                changedLights[x][y] = lights[x][y].withState(nextState);
            }
        }
        return changedLights;
    }
}
