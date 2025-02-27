package com.adventofcode;

import com.adventofcode.day01.Day01;
import com.adventofcode.day02.Day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        day01();
        day02();
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
        List<List<Integer>> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                List<Integer> subList = new ArrayList<>();
                String[] xes = scanner.nextLine().split("x");
                for (String s :
                        xes) {
                    subList.add(Integer.parseInt(s));
                }
                list.add(subList);
            }
            return list;
        } catch (FileNotFoundException exception) {
            throw new RuntimeException("File not found: " + file.getAbsolutePath(), exception);
        }
    }
}
