package com.adventofcode.day14;

public class Reindeer {
    private final int speed;
    private final int sprintTime;
    private final int cycle;
    private int score;
    private int traveledDistance;
    private boolean ready;

    public Reindeer(int speed, int sprintTime, int restTime) {
        this.speed = speed;
        this.sprintTime = sprintTime;
        traveledDistance = 0;
        score = 0;
        ready = true;
        cycle = sprintTime + restTime;
    }

    public int getTraveledDistance() {
        return traveledDistance;
    }

    public void move() {
        check();
        if (ready) {
            traveledDistance += speed;
        }
    }

    private void check() {
        if (Day14.time != 0) {
            if (ready) {
                ready = Day14.time % cycle < sprintTime;
            }
            if (Day14.time % cycle == 0) {
                ready = true;
            }
        }
    }

    public void addScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}
