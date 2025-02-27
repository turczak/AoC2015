package com.adventofcode.day01;

import java.util.List;

public class Day01 {

    public int calculateFloor(List<Character> inputList) {
        return inputList.stream()
                .mapToInt(this::checkFloor)
                .sum();
    }

    private int checkFloor(char character) {
        return switch (character) {
            case '(' -> 1;
            case ')' -> -1;
            default -> 0;
        };
    }
}
