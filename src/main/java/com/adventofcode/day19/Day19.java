package com.adventofcode.day19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day19 {
    private static final Pattern REPLACEMENT_PATTERN = Pattern.compile("(\\w+) => (\\w+)");
    private String puzzle;
    private final Map<String, List<String>> replacements = new HashMap<>();

    public Day19(List<String> input) {
        input.forEach(this::parse);
        System.out.println(puzzle);
        System.out.println(replacements);
    }

    private void parse(String line) {
        Matcher matcher = REPLACEMENT_PATTERN.matcher(line);
        if (matcher.find()) {
            String key = matcher.group(1);
            String value = matcher.group(2);
            if (!replacements.containsKey(key)) {
                replacements.put(key, new ArrayList<>());
            }
            replacements.get(key).add(value);
        } else {
            puzzle = line;
        }
    }
}
