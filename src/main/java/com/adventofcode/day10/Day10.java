package com.adventofcode.day10;

import java.util.stream.Stream;

public class Day10 {

    public int calculate(String original, int n) {
        return Stream.iterate(original, this::lookAndSay)
                .limit(n + 1)
                .reduce((oldWord, newWord) -> newWord)
                .orElse(original)
                .length();
    }

    private String lookAndSay(String input) {
        StringBuilder result = new StringBuilder();
        int counter = 1;
        for (int i = 0; i < input.length(); i++) {
            if (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                counter++;
            } else {
                result.append(counter).append(input.charAt(i));
                counter = 1;
            }
        }
        return result.toString();
    }
}
