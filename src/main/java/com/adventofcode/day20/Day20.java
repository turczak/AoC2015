package com.adventofcode.day20;

import java.util.HashMap;
import java.util.Map;

public class Day20 {

    private final int target;
    private final Map<Integer, Integer> houses = new HashMap<>();

    public Day20(int input) {
        this.target = input;
    }

    private void deliverPresents(int limit, int multiplier) {
        int sizeLimit = target / multiplier;
        for (int elf = 1; elf <= sizeLimit; elf++) {
            int deliveries = 0;
            for (int house = elf; house <= sizeLimit; house += elf) {
                houses.merge(house, elf * multiplier, Integer::sum);
                if (deliveries++ == limit) {
                    break;
                }
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

    public String partI() {
        houses.clear();
        deliverPresents(Integer.MAX_VALUE, 10);
        return "Lowest house number with at least " + target + " presents: " + findLowestHouseNumber();
    }

    public String partII() {
        houses.clear();
        deliverPresents(50, 11);
        return "Lowest house number with at least " + target + " presents: " + findLowestHouseNumber();
    }
}
