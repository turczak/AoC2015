package com.adventofcode;

import com.adventofcode.day01.Day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        day01();
    }

    private static void day01() {
        File file = new File("src/main/resources/inputs/day01.txt");
        Day01 day01 = new Day01();
        List<Character> day01_input = inputAsListOfCharacters(file);
        System.out.println("Day 1, part I result: " + day01.calculateFloor(day01_input));
        System.out.println("Day 1, part II result: " + day01.findPositionOfBasementEnter(day01_input));
    }

    private static List<Character> inputAsListOfCharacters(File file) {
        try {
            Scanner scanner = new Scanner(file);
            return scanner.next()
                    .chars()
                    .mapToObj(c -> (char) c)
                    .toList();
        } catch (FileNotFoundException exception) {
            throw new RuntimeException("File not found: " + file.getAbsolutePath(), exception);
        }
    }
}
