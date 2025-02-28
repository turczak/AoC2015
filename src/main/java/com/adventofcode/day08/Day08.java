package com.adventofcode.day08;

import java.util.List;

public class Day08 {

    public int calculate(List<String> list) {
        return list.stream().mapToInt(this::count).sum();
    }

    private int count(String line) {
        return line.length() - line.substring(1, line.length() - 1)
                .replace("\\\\", "a")
                .replace("\\\"", "b")
                .replaceAll("\\\\x[0-9a-fA-F]{2}", "c").length();
    }
}
