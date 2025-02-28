package com.adventofcode.day06;

import com.adventofcode.day03.Coordinates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day06 {
    private final Map<Coordinates, Light> lights = new HashMap<>();
    private final List<Instruction> instructions = new ArrayList<>();

    public Day06(List<String> list) {
        list.forEach(line -> instructions.add(new Instruction(line)));
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
                    case "turn on" -> light = new Light()
                            .withState(true)
                            .withBrightness(light.brightness() + 1);
                    case "turn off" -> light = new Light()
                            .withState(false)
                            .withBrightness(Math.max(0, light.brightness() - 1));
                    case "toggle" -> light = new Light()
                            .withState(!light.state())
                            .withBrightness(light.brightness() + 2);
                }
                lights.put(coords, light);
            }
        }
    }

    public int howManyLightsAreLit() {
        return (int) lights.values()
                .stream()
                .filter(Light::state)
                .count();
    }
}
