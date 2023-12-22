package solutions.day6;

import solutions.day3.Coordinates;

import java.math.BigInteger;
import java.util.*;

public class Day6 {
    private HashMap<Coordinates, Light> lights;
    private List<Instruction> instructions;

    public Day6(List<String> list) {
        this.instructions = new ArrayList<>();
        for (String s :
                list) {
            instructions.add(new Instruction(s));
        }
        this.lights = new HashMap<>();
        createLights();
        doInstructions();
    }

    private void createLights() {
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                lights.put(new Coordinates(i, j), new Light());
            }
        }
    }

    private void makeAction(Instruction instruction) {
        for (int i = instruction.getStart().getX(); i <= instruction.getEnd().getX(); i++) {
            for (int j = instruction.getStart().getY(); j <= instruction.getEnd().getY(); j++) {
                Coordinates coords = new Coordinates(i, j);
                Light light = lights.get(coords);
                switch (instruction.getCommand()) {
                    case "turn on" -> {
                        light.setState(true);
                        light.setBrightness(light.getBrightness() + 1);
                    }
                    case "turn off" -> {
                        light.setState(false);
                        light.setBrightness(Math.max(0, light.getBrightness() - 1));
                    }
                    case "toggle" -> {
                        light.setState(!light.getState());
                        light.setBrightness(light.getBrightness() + 2);
                    }
                }
            }
        }
    }

    private void doInstructions() {
        for (Instruction instruction :
                instructions) {
            makeAction(instruction);
        }
    }

    public int howManyLightAreLit() {
        int counter = 0;
        for (Map.Entry<Coordinates, Light> light :
                lights.entrySet()) {
            if (light.getValue().getState()) {
                counter++;
            }
        }
        return counter;
    }

    public int calculateTotalBrightness() {
        int total = 0;
        for (Map.Entry<Coordinates, Light> light :
                lights.entrySet()) {
            total += light.getValue().getBrightness();
        }
        return total;
    }
}
