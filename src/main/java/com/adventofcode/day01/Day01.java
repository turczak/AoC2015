package com.adventofcode.day01;

import java.util.List;

public class Day01 {

    public int calculateFloor(List<Character> inputList) {
        return inputList.stream()
                .mapToInt(this::checkFloor)
                .sum();
    }

    private int checkFloor(Character character) {
        switch (character) {
            case '(' -> {
                return 1;
            }
            case ')' -> {
                return -1;
            }
            default -> {
                return 0;
            }
        }
    }
}
