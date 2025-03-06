package com.adventofcode.day14;

public class Reindeer {
    private final int speed;
    private final int sprintTime;
    private final int restTime;
    private int score = 0;
    private int traveledDistance = 0;
    private boolean ready = true;

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
        if (ready) {
            ready = time % (cycle) < sprintTime;
        }
        if (time % (cycle) == 0) {
            ready = true;
        }
        return ready;
    }

    public void addScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}
