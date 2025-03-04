package com.adventofcode.day08;

import java.util.List;

public class Day08 {

    private static final String HEXADECIMAL = "\\\\x[0-9a-fA-F]{2}";

    public int calculate(List<String> list) {
        return list.stream()
                .mapToInt(this::replace)
                .sum();
    }

    public int calculateEncoded(List<String> list) {
        return list.stream()
                .mapToInt(this::replaceEncoded)
                .sum();
    }

    private int replace(String word) {
        return word.length() - word.substring(1, word.length() - 1)
                .replace("\\\\", "a")
                .replace("\\\"", "b")
                .replaceAll(HEXADECIMAL, "c").length();
    }

    private int replaceEncoded(String word) {
        return word.replace("\\", "aa")
                .replace("\"", "bb")
                .length() - word.length() + 2;
    }
}
