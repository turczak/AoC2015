package com.adventofcode.day16;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day16 {
    private final List<Aunt> aunts;
    private final Map<String, Integer> tickerTape;
    private final static Pattern AUNT_PATTERN = Pattern.compile("Sue (\\d+): (\\w+): (\\d+), (\\w+): (\\d+), (\\w+): (\\d+)");

    public Day16(List<String> input, Map<String, Integer> tickerTape) {
        aunts = input.stream().map(this::parse).toList();
        this.tickerTape = tickerTape;
    }

    public Aunt findCorrectAuntI() {
        return aunts.stream().filter(aunt -> aunt.gifts().entrySet().stream().allMatch(entry -> tickerTape.containsKey(entry.getKey()) && tickerTape.get(entry.getKey()).equals(entry.getValue()))).findFirst().orElse(null);
    }

    public Aunt findCorrectAuntII() {
        return aunts.stream().filter(aunt -> aunt.gifts().entrySet().stream().allMatch(entry -> {
            String key = entry.getKey();
            int value = entry.getValue();
            int target = tickerTape.getOrDefault(key, -1);
            if (target == -1) {
                return false;
            }
            return switch (key) {
                case "cats", "trees" -> value > target;
                case "pomeranians", "goldfish" -> value < target;
                default -> value == target;
            };
        })).findFirst().orElse(null);

    }

    private Aunt parse(String line) {
        Matcher matcher = AUNT_PATTERN.matcher(line);
        if (!matcher.matches()) {
            throw new RuntimeException("Invalid line: " + line);
        }
        int index = Integer.parseInt(matcher.group(1));
        Map<String, Integer> gifts = Map.ofEntries(
                Map.entry(matcher.group(2), Integer.parseInt(matcher.group(3))),
                Map.entry(matcher.group(4), Integer.parseInt(matcher.group(5))),
                Map.entry(matcher.group(6), Integer.parseInt(matcher.group(7)))
        );
        return new Aunt(index, gifts);
    }
}
