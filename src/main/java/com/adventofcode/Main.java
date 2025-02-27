package com.adventofcode;

import com.adventofcode.day01.Day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File file;
        /*Day 1*/
        file = new File("src/main/resources/inputs/day01.txt");
        Day01 day01 = new Day01();
        System.out.println("Day 1, part I result: " + day01.calculateFloor(inputAsListOfCharacters(file)));
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
