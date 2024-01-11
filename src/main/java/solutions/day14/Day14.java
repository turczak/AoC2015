package solutions.day14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day14 {
    private HashMap<Reindeer, Integer> reindeers;
    private int maxDistance;

    public Day14(List<String> input) {
        reindeers = new HashMap<>();
        maxDistance = 0;
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
            reindeers.put(reindeer, 0);
        }
    }

    public void run(int raceDuration) {
        for (Map.Entry<Reindeer, Integer> entry :
                reindeers.entrySet()) {
            Reindeer reindeer = entry.getKey();
            reindeer.run(raceDuration);
            int traveledDistance = reindeer.getTraveledDistance();
            if (traveledDistance > maxDistance) maxDistance = traveledDistance;
        }
    }

    public int getMaxDistance() {
        return maxDistance;
    }
}
