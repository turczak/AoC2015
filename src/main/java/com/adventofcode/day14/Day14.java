package com.adventofcode.day14;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day14 {
    private final Set<Reindeer> reindeerSet = new HashSet<>();
    private final Set<Reindeer> leaders = new HashSet<>();

    public Day14(List<String> input) {
        input.forEach(this::populate);
    }

    public void run() {
        int time = 0;
        while (time < 2503) {
            int maxDistanceForTurn = 0;
            for (Reindeer reindeer : reindeerSet) {
                reindeer.move(time);
                maxDistanceForTurn = getMaxDistanceForTurn(reindeer,
                        maxDistanceForTurn);
            }
            leaders.forEach(Reindeer::addScore);
            time++;
        }
    }

    private int getMaxDistanceForTurn(Reindeer reindeer, int maxDistanceForTurn) {
        int traveledDistance = reindeer.getTraveledDistance();
        if (traveledDistance > maxDistanceForTurn) {
            maxDistanceForTurn = traveledDistance;
            leaders.clear();
            leaders.add(reindeer);
        }
        if (traveledDistance == maxDistanceForTurn) {
            leaders.add(reindeer);
        }
        return maxDistanceForTurn;
    }

    public int getMaxDistance() {
        return reindeerSet.stream()
                .mapToInt(Reindeer::getTraveledDistance)
                .max()
                .orElse(0);
    }

    public int getMaxScore() {
        return reindeerSet.stream()
                .mapToInt(Reindeer::getScore)
                .max()
                .orElse(0);
    }

    private void populate(String line) {
        String[] split = line.split(" ");
        Reindeer reindeer = new Reindeer(Integer.parseInt(split[3]),
                Integer.parseInt(split[6]),
                Integer.parseInt(split[13])
        );
        this.reindeerSet.add(reindeer);
    }
}
