package com.adventofcode.day19;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day19 {
    private static final Pattern REPLACEMENT_PATTERN = Pattern.compile("(\\w+) => (\\w+)");
    private String puzzle;
    private final List<Replacement> replacements = new ArrayList<>();

    public Day19(List<String> input) {
        input.forEach(this::parse);
        System.out.println(puzzle);
        System.out.println(replacements);
    }

    private void parse(String line) {
        Matcher matcher = REPLACEMENT_PATTERN.matcher(line);
        if (matcher.find()) {
            replacements.add(new Replacement(matcher.group(1), matcher.group(2)));
        } else {
            puzzle = line;
        }
    }
}
