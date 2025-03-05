package com.adventofcode.day14;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day14 {
    private final Set<Reindeer> reindeers;
    public static int counter;

    public Day14(List<String> input) {
        reindeers = new HashSet<>();
        Day14.counter = 0;
        createReindeers(input);
    }

    private void createReindeers(List<String> input) {
        for (String line :
                input) {
            String[] split = line.split(" ");
            Reindeer reindeer = new Reindeer(split[0],
                    Integer.parseInt(split[3]),
                    Integer.parseInt(split[6]),
                    Integer.parseInt(split[13])
            );
            reindeers.add(reindeer);
        }
    }

    public int getMaxDistance() {
        return reindeers.stream()
                .mapToInt(Reindeer::getTraveledDistance)
                .max()
                .orElse(0);
    }

    public int getMaxScore() {
        return reindeers.stream()
                .mapToInt(Reindeer::getScore)
                .max()
                .orElse(0);
    }

    public void run(int raceDuration) {
        while (raceDuration > 0) {
            int maxDistanceForTurn = 0;
            Set<Reindeer> leaders = new HashSet<>();
            for (Reindeer reindeer :
                    reindeers) {
                reindeer.action();
                int traveledDistance = reindeer.getTraveledDistance();
                if (traveledDistance > maxDistanceForTurn) {
                    maxDistanceForTurn = traveledDistance;
                    leaders.clear();
                    leaders.add(reindeer);
                } else if (traveledDistance == maxDistanceForTurn) leaders.add(reindeer);
            }
            for (Reindeer reindeer :
                    leaders) {
                reindeer.addScore();
            }
            counter++;
            raceDuration--;
        }
    }
}
