package com.adventofcode.day16;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day16 {
    private final List<Aunt> aunts;
    private final Pattern LINE_PATTERN = Pattern.compile("Sue (\\d+): (.*)");
    private final Pattern ATTRIBUTE_PATTERN = Pattern.compile("(\\w+): (\\d+)");

    public Day16(List<String> input) {
        aunts = input.stream()
                .map(this::parse)
                .toList();
        System.out.println(aunts);
    }

    private Aunt parse(String line) {
        Matcher lineMatcher = LINE_PATTERN.matcher(line);
        if (!lineMatcher.matches()) {
            throw new RuntimeException("Invalid line: " + line);
        }
        int index = Integer.parseInt(lineMatcher.group(1));
        String giftsPart = lineMatcher.group(2);
        Map<String, Integer> gifts = new HashMap<>();
        Matcher giftsMatcher = ATTRIBUTE_PATTERN.matcher(giftsPart);
        while (giftsMatcher.find()) {
            String key = giftsMatcher.group(1);
            int value = Integer.parseInt(giftsMatcher.group(2));
            gifts.put(key, value);
        }
        return new Aunt(index, gifts);
    }
}
