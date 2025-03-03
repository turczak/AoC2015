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
        String key = "";
        char value = ' ';
        if (split.length == 3) {
            if (split[0].matches("\\d+")) {
                value = (char) Integer.parseInt(split[0]);
            } else if (wires.containsKey(split[0])) {
                value = wires.get(split[0]);
            }
            key = split[2];
        } else if (line.contains("NOT") && wires.containsKey(split[1])) {
            value = (char) ~wires.get(split[1]);
            key = split[3];
        } else if (line.contains("AND") || line.contains("OR")) {
            if (wires.containsKey(split[0]) && wires.containsKey(split[2])) {
                value = switch (split[1]) {
                    case "AND" -> (char) (wires.get(split[0]) & wires.get(split[2]));
                    case "OR" -> (char) (wires.get(split[0]) | wires.get(split[2]));
                    default -> throw new IllegalStateException("Unexpected value: " + split[1]);
                };
            } else if (split[0].matches("\\d+") && wires.containsKey(split[2])) {
                value = (char) (Short.parseShort(split[0]) & wires.get(split[2]));
            }
            key = split[4];
        } else if (line.contains("SHIFT")) {
            if (wires.containsKey(split[0])) {
                char shiftValue = (char) Integer.parseInt(split[2]);
                value = switch (split[1]) {
                    case "LSHIFT" -> (char) (wires.get(split[0]) << shiftValue);
                    case "RSHIFT" -> (char) (wires.get(split[0]) >> shiftValue);
                    default -> throw new IllegalStateException("Unexpected value: " + split[1]);
                };
                key = split[4];
            }
        } else {
            return false;
        }
        if (!key.isBlank() && value != ' ') {
            wires.put(key, value);
            return true;
        }
        return false;
    }
}
