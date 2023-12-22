package solutions.day6;

import solutions.day3.Coordinates;

import java.util.*;

public class Day6 {
    private HashMap<Coordinates, Boolean> lights;
    private List<Instruction> instructions;

    public HashMap<Coordinates, Boolean> getLights() {
        return lights;
    }

    public Day6(List<String> list) {
        this.instructions = new ArrayList<>();
        for (String s :
                list) {
            instructions.add(new Instruction(s));
        }
        this.lights = new HashMap<>();
        createLights();
    }

    private void createLights() {
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                lights.put(new Coordinates(i, j), false);
            }
        }
    }

    private void makeAction(Instruction instruction) {
        for (int i = instruction.getStart().getX(); i <= instruction.getEnd().getX(); i++) {
            for (int j = instruction.getStart().getY(); j <= instruction.getEnd().getY(); j++) {
                Coordinates coords = new Coordinates(i, j);
                switch (instruction.getCommand()) {
                    case "turn on" -> lights.put(coords, true);
                    case "turn off" -> lights.put(coords, false);
                    case "toggle" -> lights.put(coords, !lights.get(coords));
                }
            }
        }
    }

    public void doInstructions() {
        for (Instruction instruction :
                instructions) {
            makeAction(instruction);
        }
    }

    public int howManyLightAreLit() {
        int counter = 0;
        for (Map.Entry<Coordinates, Boolean> light :
                lights.entrySet()) {
            if (light.getValue()) {
                counter++;
            }
        }
        return counter;
    }
}
