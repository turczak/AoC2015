package com.adventofcode.day14;

public class Reindeer {
    private final int speed;
    private final int sprintTime;
    private final int restTime;
    private int score;
    private int traveledDistance;

    public Reindeer(int speed, int sprintTime, int restTime) {
        this.speed = speed;
        this.sprintTime = sprintTime;
        this.restTime = restTime;
    }

    public int getTraveledDistance() {
        return traveledDistance;
    }

    public void move(int time) {
        if (check(time)) {
            traveledDistance += speed;
        }
    }

    private boolean check(int time) {
        int cycle = sprintTime + restTime;
        return (time % (cycle) < sprintTime) || (time % (cycle) == 0);
    }

    public void addScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}
