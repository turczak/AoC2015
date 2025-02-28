package com.adventofcode.day08;

import java.util.List;

public class Day08 {

    public int calculate(List<String> list, boolean encoded) {
        return encoded ? list.stream().mapToInt(this::encodedCount).sum() : list.stream().mapToInt(this::count).sum();
    }

    private int count(String word) {
        return word.length() - word.substring(1, word.length() - 1)
                .replace("\\\\", "a")
                .replace("\\\"", "b")
                .replaceAll("\\\\x[0-9a-fA-F]{2}", "c").length();
    }

    private int encodedCount(String word) {
        return word.replace("\\", "aa")
                .replace("\"", "bb")
                .length() - word.length() + 2;
    }
}
