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

    public int runPart2(List<String> inputList) {
        char value = wires.get("a");
        wires.clear();
        wires.put("b", value);
        return run(inputList);
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
        return updateWireIfValid(split[2], getValue(split));
    }

    private char getValue(String[] split) {
        if (split[0].matches("\\d+")) {
            return (char) Integer.parseInt(split[0]);
        }
        if (wires.containsKey(split[0])) {
            return wires.get(split[0]);
        }
        return ' ';
    }

    private boolean handleNot(String line) {
        String[] split = line.split(" ");
        return updateWireIfValid(split[3], (char) ~wires.get(split[1]));
    }

    private boolean handleAndOr(String[] split) {
        return updateWireIfValid(split[4], getValue2(split));
    }

    private char getValue2(String[] split) {
        if (wires.containsKey(split[0]) && wires.containsKey(split[2])) {
            return switch (split[1]) {
                case "AND" -> (char) (wires.get(split[0]) & wires.get(split[2]));
                case "OR" -> (char) (wires.get(split[0]) | wires.get(split[2]));
                default -> throw new IllegalStateException("Unexpected value: " + split[1]);
            };
        }
        if (split[0].matches("\\d+") && wires.containsKey(split[2])) {
            return (char) (Short.parseShort(split[0]) & wires.get(split[2]));
        }
        return ' ';
    }

    private boolean handleShift(String[] split) {
        return updateWireIfValid(split[4], getValue3(split));
    }

    private char getValue3(String[] split) {
        if (!wires.containsKey(split[0])) {
            return ' ';
        }
        char shiftValue = (char) Integer.parseInt(split[2]);
        return switch (split[1]) {
            case "LSHIFT" -> (char) (wires.get(split[0]) << shiftValue);
            case "RSHIFT" -> (char) (wires.get(split[0]) >> shiftValue);
            default -> throw new IllegalStateException("Unexpected value: " + split[1]);
        };
    }
}
