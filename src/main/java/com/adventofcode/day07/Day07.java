package com.adventofcode.day07;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Day07 {
    private final Map<String, Character> wires = new HashMap<>();

    public int run(List<String> inputList) {
        LinkedList<String> list = new LinkedList<>(inputList);
        while (!list.isEmpty()) {
            list.removeIf(this::doCommand);
        }
        return wires.get("a");
    }

    private boolean doCommand(String line) {
        String[] split = line.split(" ");
        if (split.length == 3) {
            return handleProvidedValue(split);
        }
        if (line.contains("NOT") && wires.containsKey(split[1])) {
            return handleNot(line);
        }
        if (line.contains("AND") || line.contains("OR")) {
            return handleAndOr(split);
        }
        if (line.contains("SHIFT")) {
            return handleShift(split);
        }
        return false;
    }

    private boolean updateWireIfValid(String key, char value) {
        if (!key.isBlank() && value != ' ') {
            wires.put(key, value);
            return true;
        }
        return false;
    }

    private boolean handleProvidedValue(String[] split) {
        char value = ' ';
        if (split[0].matches("\\d+")) {
            value = (char) Integer.parseInt(split[0]);
        } else if (wires.containsKey(split[0])) {
            value = wires.get(split[0]);
        }
        String key = split[2];
        return updateWireIfValid(key, value);
    }

    private boolean handleNot(String line) {
        String[] split = line.split(" ");
        char value = (char) ~wires.get(split[1]);
        String key = split[3];
        return updateWireIfValid(key, value);
    }

    private boolean handleAndOr(String[] split) {
        char value = ' ';
        if (wires.containsKey(split[0]) && wires.containsKey(split[2])) {
            value = switch (split[1]) {
                case "AND" -> (char) (wires.get(split[0]) & wires.get(split[2]));
                case "OR" -> (char) (wires.get(split[0]) | wires.get(split[2]));
                default -> throw new IllegalStateException("Unexpected value: " + split[1]);
            };
        } else if (split[0].matches("\\d+") && wires.containsKey(split[2])) {
            value = (char) (Short.parseShort(split[0]) & wires.get(split[2]));
        }
        String key = split[4];
        return updateWireIfValid(key, value);
    }

    private boolean handleShift(String[] split) {
        String key = "";
        char value = ' ';
        if (wires.containsKey(split[0])) {
            char shiftValue = (char) Integer.parseInt(split[2]);
            value = switch (split[1]) {
                case "LSHIFT" -> (char) (wires.get(split[0]) << shiftValue);
                case "RSHIFT" -> (char) (wires.get(split[0]) >> shiftValue);
                default -> throw new IllegalStateException("Unexpected value: " + split[1]);
            };
            key = split[4];
        }
        return updateWireIfValid(key, value);
    }
}
