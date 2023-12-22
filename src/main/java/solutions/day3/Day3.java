package solutions.day3;

import java.util.HashMap;
import java.util.List;

public class Day3 {
    private HashMap<Coordinates, Integer> visitedHouses;

    public Day3() {
        this.visitedHouses = new HashMap<>();
    }

    private int getHouses() {
        return this.visitedHouses.size();
    }

    public int deliverPresents(List<Character> instructions, WorkType type) {
        Coordinates santaCoords = new Coordinates();
        Coordinates roboSantaCoords = new Coordinates();

        //starting positions, 's' for skip in switch
        markHouse(santaCoords, 's');
        if (type.equals(WorkType.DUO)) markHouse(roboSantaCoords, 's');

        for (int i = 0; i < instructions.size(); i++) {
            if (type.equals(WorkType.DUO)) {
                if (i % 2 == 0) {
                    santaCoords = markHouse(santaCoords, instructions.get(i));
                } else {
                    roboSantaCoords = markHouse(roboSantaCoords, instructions.get(i));
                }
            } else if (type.equals(WorkType.SOLO)) {
                santaCoords = markHouse(santaCoords, instructions.get(i));
            }
        }
        return getHouses();
    }

    private Coordinates markHouse(Coordinates oldCoords, Character direction) {
        Coordinates newCoords = new Coordinates(oldCoords);
        switch (direction) {
            case '>' -> newCoords.setX(oldCoords.getX() + 1);
            case '<' -> newCoords.setX(oldCoords.getX() - 1);
            case '^' -> newCoords.setY(oldCoords.getY() + 1);
            case 'v' -> newCoords.setY(oldCoords.getY() - 1);
        }
        visitedHouses.put(newCoords, visitedHouses.getOrDefault(newCoords, 0) + 1);
        return newCoords;
    }

}
