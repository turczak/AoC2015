package com.adventofcode.day06;

import com.adventofcode.day03.Coordinates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day06 {
    private final Map<Coordinates, Light> lights = new HashMap<>();

    public Day06(List<String> list) {
        List<Instruction> instructions = new ArrayList<>();
        list.stream()
                .map(Instruction::fromString)
                .forEach(instructions::add);
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                lights.put(new Coordinates(i, j), new Light());
            }
        }
        instructions.forEach(this::doInstruction);
    }

    private void doInstruction(Instruction instruction) {
        for (int i = instruction.start().x(); i <= instruction.end().x(); i++) {
            for (int j = instruction.start().y(); j <= instruction.end().y(); j++) {
                Coordinates coords = new Coordinates(i, j);
                Light light = lights.get(coords);
                switch (instruction.command()) {
                    case "turn on" -> {
                        light.setState(true);
                        light.setBrightness(light.getBrightness() + 1);
                    }
                    case "turn off" -> {
                        light.setState(false);
                        light.setBrightness(light.getBrightness() - 1);
                    }
                    case "toggle" -> {
                        light.setState(!light.getState());
                        light.setBrightness(light.getBrightness() + 2);
                    }
                }
                lights.put(coords, light);
            }
        }
    }

    public int howManyLightsAreLit() {
        return (int) lights.values()
                .stream()
                .filter(Light::getState)
                .count();
    }
}
