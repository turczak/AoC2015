package com.adventofcode.day08;

import java.util.List;

public class Day08 {

    public int calculate(List<String> list, boolean encoded) {
        return list.stream().mapToInt(word -> {
            if (encoded) {
                return word.replace("\\", "aa")
                        .replace("\"", "bb")
                        .length() - word.length() + 2;
            } else {
                return word.length() - word.substring(1, word.length() - 1)
                        .replace("\\\\", "a")
                        .replace("\\\"", "b")
                        .replaceAll("\\\\x[0-9a-fA-F]{2}", "c").length();
            }
        }).sum();
    }
}
