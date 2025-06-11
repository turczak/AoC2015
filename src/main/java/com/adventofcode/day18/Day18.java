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

}
