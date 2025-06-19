package com.adventofcode.day20;

import java.util.HashMap;
import java.util.Map;

public class Day20 {

    private final int target;
    private final Map<Integer, Integer> houses = new HashMap<>();

    public Day20(int input) {
        this.target = input;
    }

    private void deliverPresents() {
        int sizeLimit = target / 10;
        for (int elf = 1; elf <= sizeLimit; elf++) {
            for (int house = elf; house <= sizeLimit; house += elf) {
                houses.merge(house, elf * 10, Integer::sum);
            }
        }
    }

    private int findLowestHouseNumber() {
        return houses.entrySet().stream()
                .filter(house -> house.getValue() >= target)
                .mapToInt(Map.Entry::getKey)
                .min()
                .orElse(-1);
    }

    public String run() {
        deliverPresents();
        return "Lowest house number with at least " + target + " presents: " + findLowestHouseNumber();
    }
}
