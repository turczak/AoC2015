import solutions.day1.Day1;
import utils.MyFileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MyFileReader fileReader = new MyFileReader(
                new File("src/main/resources/test.txt"));

        System.out.println("Answers for specific tasks: \n");

        //Day 1, part I
        Day1 day1 = new Day1();
        fileReader.changeFile(new File("src/main/java/solutions/day1/input.txt"));
        List<Character> day1_input = fileReader.inputAsListOfCharacters();
        System.out.println("Day 1, part I: " +
                day1.calculateFloor(day1_input));
        //Day 1, part II
        System.out.println("Day 1, part II: " +
                day1.findPositionOfCharacter(day1_input));
    }
}
