package com.adventofcode.day18;

import com.adventofcode.day06.Light;

import java.util.List;

public class Day18 {

    private Light[][] lights = new Light[100][100];

    public Day18(List<String> input) {
        lights = parseToGrid(input);
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
                if ((neighborX != 0 || neighborY != 0) && // ignore my position
                        neighborX >= 0 && neighborX < lights.length && // check borders
                        neighborY >= 0 && neighborY < lights[0].length && // check borders
                        lights[neighborX][neighborY].state()) {
                    neighbors++;
                }
            }
        }
        return neighbors;
    }


}
