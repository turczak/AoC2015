package solutions.day14;

public class Reindeer {
    private String name;
    private int speed;
    private int sprintTime;
    private int restTime;

    private int traveledDistance;

    public Reindeer(String name, int speed, int sprintTime, int restTime) {
        this.name = name;
        this.speed = speed;
        this.sprintTime = sprintTime;
        this.restTime = restTime;
        this.traveledDistance = 0;
    }

    public void run(int duration) {
        int cycleTime = sprintTime + restTime;
        int cycles = duration / cycleTime;
        int remainingTime = duration % cycleTime;

        int allCyclesDistance = cycles * sprintTime * speed;
        int remainingTimeDistance = Math.min(remainingTime, sprintTime) * speed;

        traveledDistance = allCyclesDistance + remainingTimeDistance;
    }

    public int getTraveledDistance() {
        return traveledDistance;
    }
}
