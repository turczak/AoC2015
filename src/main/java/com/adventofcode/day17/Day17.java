package com.adventofcode.day17;

import java.util.List;

public class Day17 {
    private final List<Container> containers;
    private final int targetSum;

    public Day17(List<Integer> input, int targetSum) {
        this.targetSum = targetSum;
        this.containers = inputAsListOfContainers(input);
    }

    private List<Container> inputAsListOfContainers(List<Integer> input) {
        return input.stream().map(Container::new).toList();
    }

    public void run() {
        int combinations = findCombinations(0, 0);
        System.out.println(combinations);
    }

    private int findCombinations(int index, int currentSum) {
        if (currentSum == targetSum) {
            return 1;
        }
        if (currentSum > targetSum || index == containers.size()) {
            return 0;
        }
        int current = findCombinations(index + 1, currentSum + containers.get(index).volume());
        int next = findCombinations(index + 1, currentSum);
        return current + next;
    }
}
