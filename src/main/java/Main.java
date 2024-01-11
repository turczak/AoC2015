import solutions.day1.Day1;
import solutions.day10.Day10;
import solutions.day11.Day11;
import solutions.day12.Day12;
import solutions.day14.Day14;
import solutions.day2.Day2;
import solutions.day3.Day3;
import solutions.day3.WorkType;
import solutions.day5.Day5;
import solutions.day8.Day8;
import solutions.day9.Day9;
import solutions.day9.SearchType;
import utils.MyFileReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
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

        //Day 5, part I
        fileReader.changeFile(new File("src/main/java/solutions/day5/input.txt"));
//        fileReader.changeFile(new File("src/main/resources/test.txt"));
        List<String> day5_input = fileReader.inputAsListOfStrings();
        Day5 day5 = new Day5(day5_input);
        System.out.println("Day 5, part I: " + day5.getCounter_v1());
        //Day 5, part II
        System.out.println("Day 5, part II: " + day5.getCounter_v2());
        System.out.println("--------------------------------");

        //Day 6, part I
        /*
        fileReader.changeFile(new File("src/main/java/solutions/day6/input.txt"));
        List<String> day6_input = fileReader.inputAsListOfStrings();
        Day6 day6 = new Day6(day6_input);
        System.out.println("Day 6, part I: " + day6.howManyLightAreLit());
        //Day 6, part II
        System.out.println("Day 6, part II: " + day6.calculateTotalBrightness());
         */

        //Day 7, part I
        /*
        fileReader.changeFile(new File("src/main/java/solutions/day7/input.txt"));
        Day7 day7 = new Day7(fileReader.inputAsListOfStrings());
        */

        //Day 8, part I
        fileReader.changeFile(new File("src/main/java/solutions/day8/input.txt"));
//        fileReader.changeFile(new File("src/main/resources/test.txt"));
        Day8 day8 = new Day8();
        day8.run(fileReader.inputAsListOfStrings());
        System.out.println(day8);
        System.out.println("----------------------------------------");

        //Day 9, part I
        fileReader.changeFile(new File("src/main/java/solutions/day9/input.txt"));
//        fileReader.changeFile(new File("src/main/resources/test.txt"));
        List<String> day9_input = fileReader.inputAsListOfStrings();
        Day9 day9 = new Day9(day9_input);
        day9.run(SearchType.SHORTEST);
        System.out.println(day9.getResultRoute());
        //Day 9, part II
        day9.run(SearchType.LONGEST);
        System.out.println(day9.getResultRoute());
        System.out.println("-------------------------");

        //Day 10, part I
        Day10 day10 = new Day10();
        String day10_input = "3113322113";
        System.out.println("Part I, length of the result is : " + day10.run(day10_input, 40));
        System.out.println("Part II, Length of the result is : " + day10.run(day10_input, 50));
        System.out.println("---------------------------");

        //Day 11
        Day11 day11 = new Day11();
        String newPassword = day11.generateNewPassword("hepxcrrq");
        System.out.println("Part I: " + newPassword);
        System.out.println("Part II: " + day11.generateNewPassword(newPassword));
        System.out.println("-------------------------------");

        // Day 12
        System.out.println("Day 12:");
        Day12 day12 = new Day12(new File("src/main/java/solutions/day12/input.json"));
        day12.run();
        System.out.println("------------------------------");

        //Day 14
        fileReader.changeFile(new File("src/main/java/solutions/day14/input.txt"));
        System.out.println("Day 14:");
        Day14 day14 = new Day14(fileReader.inputAsListOfStrings());
        day14.run(2503);
        System.out.println("Winning reindeer traveled " + day14.getMaxDistance() + "km");
    }
}
