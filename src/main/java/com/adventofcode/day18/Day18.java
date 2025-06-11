package com.adventofcode.day18;

import com.adventofcode.day06.Light;

import java.util.Arrays;
import java.util.List;

public class Day18 {

    private Light[][] lights = new Light[100][100];

    public Day18(List<String> input, int steps) {
        lights = parseToGrid(input);
        for (int i = 0; i < steps; i++) {
            makeStep();
        }
    }

    public long countLights() {
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

    private int countNeighbors(int x, int y) {
        int neighbors = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int neighborX = x + i;
                int neighborY = y + j;
                if ((i != 0 || j != 0) && // ignore my position
                        neighborX >= 0 && neighborX < lights.length && // check borders
                        neighborY >= 0 && neighborY < lights[0].length && // check borders
                        lights[neighborX][neighborY].state()) {
                    neighbors++;
                }
            }
        }
        return neighbors;
    }

    private void makeStep() {
        Light[][] changedLights = new Light[100][100];
        for (int x = 0; x < lights.length; x++) {
            for (int y = 0; y < lights[0].length; y++) {
                int neighbors = countNeighbors(x, y);
                boolean nextState;
                if (lights[x][y].state()) {
                    nextState = (neighbors == 2 || neighbors == 3);
                } else {
                    nextState = (neighbors == 3);
                }
                changedLights[x][y] = lights[x][y].withState(nextState);
            }
        }
        lights = changedLights;
    }
}
