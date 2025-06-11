package com.adventofcode;

import com.adventofcode.day01.Day01;
import com.adventofcode.day02.Day02;
import com.adventofcode.day03.Day03;
import com.adventofcode.day04.Day04;
import com.adventofcode.day05.CheckingMethod;
import com.adventofcode.day05.Day05;
import com.adventofcode.day06.Day06;
import com.adventofcode.day07.Day07;
import com.adventofcode.day08.Day08;
import com.adventofcode.day09.Day09;
import com.adventofcode.day09.SearchType;
import com.adventofcode.day10.Day10;
import com.adventofcode.day11.Day11;
import com.adventofcode.day12.Day12;
import com.adventofcode.day15.Day15;
import com.adventofcode.day17.Day17;
import com.adventofcode.day18.Day18;

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
                case 6 -> day06();
                case 7 -> day07();
                case 8 -> day08();
                case 9 -> day09();
                case 10 -> day10();
                case 11 -> day11();
                case 12 -> day12();
                case 15 -> day15();
                case 17 -> day17();
                case 18 -> day18();
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

    private static void day06() {
        File file = new File("src/main/resources/inputs/day06.txt");
        List<String> input = inputAsListOfStrings(file);
        Day06 day06 = new Day06();
        day06.run(input);
        System.out.println("Day 6, part I result: " + day06.howManyLightsAreLit());
        System.out.println("Day 6, part II result: " + day06.totalBrightness());
    }

    private static void day07() {
        Day07 day07 = new Day07();
        File file = new File("src/main/resources/inputs/day07.txt");
        List<String> input = inputAsListOfStrings(file);
        System.out.println("Day 7, part I result: " + day07.run(input));
        System.out.println("Day 7, part II result: " + day07.runPart2(input));
    }

    private static void day08() {
        Day08 day08 = new Day08();
        File file = new File("src/main/resources/inputs/day08.txt");
        List<String> input = inputAsListOfStrings(file);
        System.out.println("Day 5, part I result: " + day08.calculate(input));
        System.out.println("Day 5, part II result: " + day08.calculateEncoded(input));
    }

    private static void day09() {
        File file = new File("src/main/resources/inputs/day09.txt");
        List<String> input = inputAsListOfStrings(file);
        Day09 day09 = new Day09();
        System.out.println("Day 9, part I result: " + day09.getResultDistance(input, SearchType.SHORTEST));
        System.out.println(day09.getResultRoute(SearchType.SHORTEST));
        System.out.println("Day 9, part II result: " + day09.getResultDistance(input, SearchType.LONGEST));
        System.out.println(day09.getResultRoute(SearchType.LONGEST));
    }

    private static void day10() {
        Day10 day10 = new Day10();
        String input = "3113322113";
        System.out.println("Day 10, part I result: " + day10.calculate(input, 40));
        System.out.println("Day 10, part II result: " + day10.calculate(input, 50));
    }

    private static void day11() {
        Day11 day11 = new Day11();
        String input = "hepxcrrq";
        String password = day11.generateNewPassword(input);
        System.out.println("Day 11, part I result: " + password);
        System.out.println("Day 11, part II result: " + day11.generateNewPassword(password));
    }

    private static void day12() {
        File file = new File("src/main/resources/inputs/day12.json");
        Day12 day12 = new Day12();
        System.out.println("Day 12, part I result: " + day12.calculateSum(file));
    }

    private static void day15() {
        File file = new File("src/main/resources/inputs/day15.txt");
        List<String> input = inputAsListOfStrings(file);
        Day15 day15 = new Day15(input);
        System.out.println(day15.run());
    }

    private static void day17() {
        File file = new File("src/main/resources/inputs/day17.txt");
        List<Integer> input = inputAsListOfIntegers(file);
        Day17 day17 = new Day17(input, 150);
        day17.run();
        System.out.println("Day 17, part I & II results: " + day17);
    }

    private static void day18() {
        File file = new File("src/main/resources/inputs/day18.txt");
        List<String> input = inputAsListOfStrings(file);
        Day18 day18 = new Day18(input, 100);
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

    private static List<Integer> inputAsListOfIntegers(File file) {
        try {
            return Files.readAllLines(file.toPath())
                    .stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (IOException exception) {
            throw new RuntimeException("File not found: " + file.getAbsolutePath(), exception);
        }
    }
}
