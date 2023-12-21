import solutions.day1.Day1;
import utils.MyFileReader;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MyFileReader fileReader = new MyFileReader(
                new File("src/main/resources/test.txt"));

        System.out.println("Answers for specific tasks: \n");

        //solution to day 1, part I
        Day1 day1 = new Day1();
        fileReader.changeFile(new File("src/main/java/solutions/day1/input.txt"));
        System.out.println("Day 1, part I: " +
                day1.calculateFloor(fileReader.inputAsListOfCharacters()));


    }
}
