package solutions.day17;

import utils.MyFileReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day17 {
    private static final List<int[]> results = new ArrayList<>();
    private static final List<int[]> filteredResults = new ArrayList<>();
    private static int minSize = Integer.MAX_VALUE;

    private static boolean isSmallest(int[] arrToCheck) {
        int counter = 0;
        for (int i = 0; i < arrToCheck.length; i++) {
            if (arrToCheck[i] == 1) counter++;
            if (counter > minSize) return false;
        }
        return counter == minSize;
    }

    private static int filterResults(List<int[]> results) {
        int numberOfDifferentWays = 0;
        for (int[] result :
                results) {
            if (isSmallest(result)) {
                numberOfDifferentWays++;
                filteredResults.add(result);
            }
        }
        return numberOfDifferentWays;
    }

    private static void find(int[] input, int sum, int index, int wantedSum,
                             int[] set) {
        if (sum == wantedSum) {
            System.out.println();
            int[] solution = new int[input.length];
            int currentSize = 0;
            for (int i = 0; i < set.length; i++) {
                if (set[i] == 1) {
                    currentSize++;
                    System.out.print("  " + input[i]);
                    solution[i] = input[i];
                }
            }
            minSize = Math.min(minSize, currentSize);
            System.out.println("\ncurrent: " + currentSize);
            System.out.print("min: " + minSize);
            results.add(set.clone());
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
        int maxSum = 150;
        int[] solution = new int[input.length];

        find(input, 0, 0, maxSum, solution);
        System.out.println("\nSolutions: " + results.size());
        filterResults(results);
        System.out.println("Different ways with minimum length: " + filteredResults.size());
    }
}
