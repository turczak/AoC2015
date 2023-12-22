package solutions.day6;

import solutions.day3.Coordinates;

public class Instruction {
    private String command;
    private Coordinates start;
    private Coordinates end;

    public Instruction(String instruction) {
        String[] split = instruction.split(" ");
        if (split.length == 5) {
            this.command = split[0] + " " + split[1];
            String[] firstCoords = split[2].split(",");
            String[] secondCoords = split[4].split(",");
            this.start = new Coordinates(Integer.parseInt(firstCoords[0]), Integer.parseInt(firstCoords[1]));
            this.end = new Coordinates(Integer.parseInt(secondCoords[0]), Integer.parseInt(secondCoords[1]));
        } else {
            this.command = split[0];
            String[] firstCoords = split[1].split(",");
            String[] secondCoords = split[3].split(",");
            this.start = new Coordinates(Integer.parseInt(firstCoords[0]), Integer.parseInt(firstCoords[1]));
            this.end = new Coordinates(Integer.parseInt(secondCoords[0]), Integer.parseInt(secondCoords[1]));
        }
    }

    public String getCommand() {
        return command;
    }

    public Coordinates getStart() {
        return start;
    }

    public Coordinates getEnd() {
        return end;
    }
}
