package com.adventofcode.day14;

public class Reindeer {
    private final String name;
    private final int speed, sprintTime, restTime;
    private int score;
    private int traveledDistance;
    private final int cycle;
    private boolean isReady;

    public Reindeer(String name, int speed, int sprintTime, int restTime) {
        this.name = name;
        this.speed = speed;
        this.sprintTime = sprintTime;
        this.restTime = restTime;
        traveledDistance = 0;
        score = 0;
        isReady = true;
        cycle = sprintTime + restTime;
    }

    public int getTraveledDistance() {
        return traveledDistance;
    }

    public void action() {
        check();
        if (isReady) traveledDistance += speed;
    }

    private void check() {
        if (Day14.counter != 0) {
            if (isReady) {
                isReady = Day14.counter % cycle < sprintTime;
            } else if (Day14.counter % cycle == 0) isReady = true;
        } else isReady = true;
    }

    public void addScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}
