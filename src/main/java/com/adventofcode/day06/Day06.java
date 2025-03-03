package com.adventofcode.day06;

import com.adventofcode.day03.Coordinates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day06 {
    private final Map<Coordinates, Light> lights = new HashMap<>();

    public int run(List<String> list) {
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
        return (int) lights.values()
                .stream()
                .filter(Light::state)
                .count();
    }

    private void doInstruction(Instruction instruction) {
        for (int i = instruction.start().x(); i <= instruction.end().x(); i++) {
            for (int j = instruction.start().y(); j <= instruction.end().y(); j++) {
                Coordinates coords = new Coordinates(i, j);
                Light light = lights.get(coords);
                light = switch (instruction.command()) {
                    case "turn on" -> light
                            .withState(true)
                            .withBrightness(light.brightness() + 1);
                    case "turn off" -> light
                            .withState(false)
                            .withBrightness(light.brightness() - 1);
                    default -> light
                            .withState(!light.state())
                            .withBrightness(light.brightness() + 2);
                };
                lights.put(coords, light);
            }
        }
    }
}
