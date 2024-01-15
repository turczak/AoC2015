package solutions.day17;

import utils.MyFileReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day17 {
    private static final List<int[]> results = new ArrayList<>();
    public static void find(int[] input, int sum, int index, int wantedSum,
                            int[] set) {
        if (sum == wantedSum) {
            System.out.println();
            int[] solution = new int[input.length];
            for (int i = 0; i < set.length; i++) {
                if (set[i] == 1) {
                    System.out.print("  " + input[i]);
                    solution[i] = input[i];
                }
            }
            results.add(set);
        } else if (index == input.length) {
            return;
        } else {
            set[index] = 1;
            sum += input[index];
            find(input, sum, index + 1, wantedSum, set);
            sum -= input[index];
            set[index] = 0;
            find(input, sum, index + 1, wantedSum, set);
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        MyFileReader reader = new MyFileReader(new File("src/main/resources/day17.txt"));
        int[] input = reader.inputAsListOfInts();
        int wantedSum = 150;
        int[] solution = new int[input.length];

        find(input,0,0,wantedSum, solution);
        System.out.println("\nSolutions: " + results.size());
    }
}
