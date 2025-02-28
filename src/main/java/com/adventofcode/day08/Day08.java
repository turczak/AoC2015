package com.adventofcode.day08;

import java.util.List;

public class Day08 {

    public int calculate(List<String> list) {
        return list.stream().mapToInt(this::count).sum();
    }

    private int count(String line) {
        int amountOfCharsInMemory = 0;
        char[] chars = line.toCharArray();
        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i] == '\\') {
                switch (chars[i + 1]) {
                    case '\\', '\"' -> i++;
                    case 'x' -> i += 3;
                    default -> throw new IllegalStateException("Unexpected value: " + chars[i + 1]);
                }
            }
            amountOfCharsInMemory++;
        }
        return line.length() - amountOfCharsInMemory;
    }
}
