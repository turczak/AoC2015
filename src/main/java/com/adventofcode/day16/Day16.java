package com.adventofcode.day16;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day16 {
    private final List<Aunt> aunts;
    private final Map<String, Integer> tickerTape;
    private final Pattern linePattern = Pattern.compile("Sue (\\d+): (.*)");
    private final Pattern giftsPattern = Pattern.compile("(\\w+): (\\d+)");

    public Day16(List<String> input, Map<String, Integer> tickerTape) {
        aunts = input.stream().map(this::parse).toList();
        this.tickerTape = tickerTape;
    }

    public int run(int part) {
        return findCorrectAunt(part).index();
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
        Matcher lineMatcher = linePattern.matcher(line);
        if (!lineMatcher.matches()) {
            throw new RuntimeException("Invalid line: " + line);
        }
        int index = Integer.parseInt(lineMatcher.group(1));
        String giftsPart = lineMatcher.group(2);
        Map<String, Integer> gifts = new HashMap<>();
        Matcher giftsMatcher = giftsPattern.matcher(giftsPart);
        while (giftsMatcher.find()) {
            String key = giftsMatcher.group(1);
            int value = Integer.parseInt(giftsMatcher.group(2));
            gifts.put(key, value);
        }
        return new Aunt(index, gifts);
    }
}
