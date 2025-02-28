package com.adventofcode;

import com.adventofcode.day01.Day01;
import com.adventofcode.day02.Day02;
import com.adventofcode.day03.Day03;
import com.adventofcode.day03.WorkType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        day01();
        day02();
        day03();
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
        System.out.println("Day 3, part I result: " + day03.deliverPresents(input, WorkType.SOLO));
        System.out.println("Day 3, part II result: " + day03.deliverPresents(input, WorkType.DUO));
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
