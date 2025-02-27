package com.adventofcode;

import com.adventofcode.day01.Day01;
import com.adventofcode.day02.Day02;
import com.adventofcode.day04.Day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choice = scanner.nextInt();
            System.out.println("Please choose day (1-25) to see results or enter 0 to exit.");
            System.out.println("Your choice: ");
            switch (choice) {
                case 0 -> {
                    scanner.close();
                    return;
                }
                case 1 -> day01();
                case 2 -> day02();
                case 4 -> day04();
                default -> System.out.println("Invalid option, please use number between 1 and 25.");
            }
        }
    }

    private static void day01() {
        File file = new File("src/main/resources/inputs/day01.txt");
        Day01 day01 = new Day01();
        List<Character> input = inputAsListOfCharacters(file);
        System.out.println("Day 1, part I result: " + day01.calculateFloor(input));
        System.out.println("Day 1, part II result: " + day01.findPositionOfBasementEnter(input));
    }

    private static void day02() {
        File file = new File("src/main/resources/inputs/day02.txt");
        Day02 day02 = new Day02();
        List<List<Integer>> input = inputAsListOfListsOfDimensions(file);
        System.out.println("Day 2, part I result: " + day02.getTotalSquareFeet(input));
        System.out.println("Day 2, part II result: " + day02.getTotalLength(input));
    }

    private static void day04() {
        File file = new File("src/main/resource/inputs/day04.txt");
        Day04 day04 = new Day04();
        System.out.println("Day 4, part I result: " + day04.findLowestPossibleNumber("00000"));
        System.out.println("Day 4, part II result: " + day04.findLowestPossibleNumber("000000"));
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

    private static List<List<Integer>> inputAsListOfListsOfDimensions(File file) {
        try {
            Scanner scanner = new Scanner(file);
            return scanner.tokens()
                    .map(line -> Arrays.stream(line.split("x"))
                            .map(Integer::parseInt)
                            .toList())
                    .toList();
        } catch (FileNotFoundException exception) {
            throw new RuntimeException("File not found: " + file.getAbsolutePath(), exception);
        }
    }
}
