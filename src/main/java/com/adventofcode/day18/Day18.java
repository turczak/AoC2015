package com.adventofcode.day18;

import java.util.List;

public class Day18 {

    private char[][] grid = new char[100][100];

    public Day18(List<String> input) {
        grid = parseToGrid(input);
    }

    private char[][] parseToGrid(List<String> input) {
        return input.stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);
    }

}
