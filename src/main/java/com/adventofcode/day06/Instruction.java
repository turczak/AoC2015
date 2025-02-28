package com.adventofcode.day06;

import com.adventofcode.day03.Coordinates;

public record Instruction(String command, Coordinates start, Coordinates end) {

    public static Instruction fromString(String instruction) {
        String command = parseCommand(instruction);
        Coordinates start;
        Coordinates end;
        if (instruction.split(" ").length == 5) {
            start = parseCoords(instruction, 2);
            end = parseCoords(instruction, 4);
        } else {
            start = parseCoords(instruction, 1);
            end = parseCoords(instruction, 3);
        }
        return new Instruction(command, start, end);
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
