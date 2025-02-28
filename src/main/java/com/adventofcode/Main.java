package com.adventofcode;

import com.adventofcode.day01.Day01;
import com.adventofcode.day02.Day02;
import com.adventofcode.day03.Day03;
import com.adventofcode.day04.Day04;
import com.adventofcode.day05.CheckingMethod;
import com.adventofcode.day05.Day05;
import com.adventofcode.day08.Day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please choose day (1-25) to see results or enter 0 to exit.");
            System.out.println("Your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0 -> {
                    scanner.close();
                    return;
                }
                case 1 -> day01();
                case 2 -> day02();
                case 3 -> day03();
                case 4 -> day04();
                case 5 -> day05();
                case 8 -> day08();
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

    private static void day03() {
        File file = new File("src/main/resources/inputs/day03.txt");
        Day03 day03 = new Day03();
        List<Character> input = inputAsListOfCharacters(file);
        System.out.println("Day 3, part I result: " + day03.deliverYourself(input));
        System.out.println("Day 3, part II result: " + day03.deliverWithRobo(input));
    }

    private static void day04() {
        Day04 day04 = new Day04();
        System.out.println("Day 4, part I result: " + day04.findLowestPossibleNumber("00000"));
        System.out.println("Day 4, part II result: " + day04.findLowestPossibleNumber("000000"));
    }

    private static void day05() {
        Day05 day05 = new Day05();
        File file = new File("src/main/resources/inputs/day05.txt");
        List<String> input = inputAsListOfStrings(file);
        System.out.println("Day 5, part I result: " + day05.howManyStringsAreNice(input, CheckingMethod.STANDARD));
        System.out.println("Day 5, part II result: " + day05.howManyStringsAreNice(input, CheckingMethod.BETTER));
    }

    private static void day08() {
        Day08 day08 = new Day08();
        File file = new File("src/main/resources/inputs/day08.txt");
        List<String> input = inputAsListOfStrings(file);
        System.out.println("Day 5, part I result: " + day08.calculate(input));
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

    private static List<String> inputAsListOfStrings(File file) {
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException exception) {
            throw new RuntimeException("File not found: " + file.getAbsolutePath(), exception);
        }
    }
}
