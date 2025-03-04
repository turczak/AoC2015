package com.adventofcode.day06;

import com.adventofcode.day03.Coordinates;

public record Instruction(String command, Coordinates start, Coordinates end) {

    public static Instruction fromString(String instruction) {
        String command = parseCommand(instruction);
        if (instruction.split(" ").length == 5) {
            return new Instruction(command,
                    parseCoords(instruction, 2),
                    parseCoords(instruction, 4));
        } else {
            return new Instruction(command,
                    parseCoords(instruction, 1),
                    parseCoords(instruction, 3));
        }
    }

    private static String parseCommand(String instruction) {
        String[] split = instruction.split(" ");
        if (instruction.contains("turn")) {
            return split[0] + " " + split[1];
        } else {
            return split[0];
        }
    }

    private static Coordinates parseCoords(String instruction, int index) {
        String[] split = instruction.split(" ");
        String[] coords = split[index].split(",");
        return new Coordinates(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
    }
}
