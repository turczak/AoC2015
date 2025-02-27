package com.adventofcode;

import com.adventofcode.day01.Day01;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        CustomFileReader fileReader = new CustomFileReader(new File("src/main/resources/inputs/day01.txt"));
        /*Day 1*/
        Day01 day01 = new Day01();
        System.out.println("Day 1, part I result: " + day01.calculateFloor(fileReader.inputAsListOfCharacters()));
    }
}
