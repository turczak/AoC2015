package com.adventofcode.day16;

import java.util.HashMap;
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

    public int partI() {
        return findCorrectAunt(1).index();
    }

    public int partII() {
        return findCorrectAunt(2).index();
    }

    private Aunt findCorrectAunt(int part) {
        return aunts.stream()
                .filter(
                        aunt -> aunt.gifts().entrySet().stream()
                                .allMatch(
                                        entry -> {
                                            if (part == 1) {
                                                return tickerTape.containsKey(entry.getKey())
                                                        && tickerTape.get(entry.getKey()).equals(entry.getValue());
                                            }
                                            if (part == 2) {
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
                                            }
                                            return false;
                                        }))
                .findFirst()
                .orElse(null);
    }

    private Aunt parse(String line) {
        Matcher matcher = AUNT_PATTERN.matcher(line);
        if (!matcher.matches()) {
            throw new RuntimeException("Invalid line: " + line);
        }
        int index = Integer.parseInt(matcher.group(1));
        Map<String, Integer> gifts = new HashMap<>();
        gifts.put(matcher.group(2), Integer.parseInt(matcher.group(3)));
        gifts.put(matcher.group(4), Integer.parseInt(matcher.group(5)));
        gifts.put(matcher.group(6), Integer.parseInt(matcher.group(7)));

        return new Aunt(index, gifts);
    }
}
