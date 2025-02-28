package com.adventofcode.day06;

import com.adventofcode.day03.Coordinates;

public record Instruction(String command, Coordinates start, Coordinates end) {

    public Instruction(String instruction) {
        this(parseCommand(instruction),
                parseCoords(instruction, instruction.split(" ").length == 5 ? 2 : 1),
                parseCoords(instruction, instruction.split(" ").length == 5 ? 4 : 3));
    }

    private static String parseCommand(String instruction) {
        String[] split = instruction.split(" ");
        return split.length == 5 ? split[0] + " " + split[1] : split[0];
    }

    private static Coordinates parseCoords(String instruction, int index) {
        String[] split = instruction.split(" ");
        String[] coords = split[index].split(",");
        return new Coordinates(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
    }
}
