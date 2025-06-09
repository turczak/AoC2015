package com.adventofcode.day17;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day17 {
    private final List<Integer> containers;
    private final int targetSum;
    private final Map<Integer, Integer> solutions = new HashMap<>();
    private int combinations = 0;

    public Day17(List<Integer> input, int targetSum) {
        this.targetSum = targetSum;
        this.containers = input;
    }

    public void run() {
        findCombinations(0, 0, 0);
        int minContainers = Collections.min(solutions.keySet());
        int ways = solutions.get(minContainers);
        System.out.println("Number of combinations: " + combinations);
        System.out.println("Minimum number of containers: " + minContainers);
        System.out.println("Number of combinations using that many containers: " + ways);
    }

    private void findCombinations(int index, int currentSum, int usedContainers) {
        if (currentSum == targetSum) {
            combinations++;
            solutions.merge(usedContainers, 1, Integer::sum);
            return;
        }
        if (currentSum > targetSum || index == containers.size()) {
            return;
        }
        findCombinations(index + 1, currentSum + containers.get(index), usedContainers + 1);
        findCombinations(index + 1, currentSum, usedContainers);
    }
}
