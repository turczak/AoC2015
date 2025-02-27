package com.adventofcode.day01;

import java.util.List;

public class Day01 {

    public int calculateFloor(List<Character> inputList) {
        return inputList.stream()
                .mapToInt(this::checkFloor)
                .sum();
    }

    public int findPositionOfBasementEnter(List<Character> inputList) {
        int sum = 0, position = 1;
        for (int i = 0; i < inputList.size(); i++) {
            sum += checkFloor(inputList.get(i));
            if (sum == -1) {
                position += i;
                break;
            }
        }
        return position;
    }

    private int checkFloor(char character) {
        return switch (character) {
            case '(' -> 1;
            case ')' -> -1;
            default -> 0;
        };
    }
}
