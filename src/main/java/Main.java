import solutions.day1.Day1;
import solutions.day2.Day2;
import solutions.day3.Day3;
import solutions.day3.WorkType;
import solutions.day4.Day4;
import utils.MyFileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException {
        MyFileReader fileReader = new MyFileReader(new File("src/main/resources/test.txt"));

        System.out.println("Answers for specific tasks: \n");

        //Day 1, part I
        Day1 day1 = new Day1();
        fileReader.changeFile(new File("src/main/java/solutions/day1/input.txt"));
        List<Character> day1_input = fileReader.inputAsListOfCharacters();
        System.out.println("Day 1, part I: " + day1.calculateFloor(day1_input));
        //Day 1, part II
        System.out.println("Day 1, part II: " + day1.findPositionOfCharacter(day1_input));
        System.out.println("-------------------------------");

        //Day 2, part I
        fileReader.changeFile(new File("src/main/java/solutions/day2/input.txt"));
        List<List<Integer>> day2_input = fileReader.inputAsListOfListsOfDimenions();
        Day2 day2 = new Day2(day2_input);
        System.out.println("Day 2, part I: " + day2.getTotalSquareFeet());
        //Day 2, part II
        System.out.println("Day 2, part II: " + day2.getTotalLengthOfRibbon());
        System.out.println("-------------------------------");

        //Day 3, part I
        fileReader.changeFile(new File("src/main/java/solutions/day3/input.txt"));
        List<Character> day3_input = fileReader.inputAsListOfCharacters();
        Day3 day3 = new Day3();
        System.out.println("Day 3, part I: " + day3.deliverPresents(day3_input, WorkType.SOLO));
        //Day 3, part II
        Day3 day3_v2 = new Day3();
        System.out.println("Day 3, part II: " + day3_v2.deliverPresents(day3_input, WorkType.DUO));
        System.out.println("-------------------------------");

        //Day 4, part I
        /*
        Day4 day4 = new Day4();
        System.out.println("Day 4, part I: " + day4.findLowestPossibleNumber("00000"));
        */
         /*
        //Day 4, part II
        System.out.println("Day 4, part II: " + day4.findLowestPossibleNumber("000000"));
          */
    }
}
