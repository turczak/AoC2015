package com.adventofcode.day02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Day02 {

    public int getTotalSquareFeet(List<List<Integer>> listOfDimensions) {
        int total = 0;
        for (List<Integer> dimensions : listOfDimensions) {
            int area1 = 2 * dimensions.get(0) * dimensions.get(2);
            int area2 = 2 * dimensions.get(2) * dimensions.get(1);
            int area3 = 2 * dimensions.get(1) * dimensions.get(0);
            int slack = Math.min(Math.min(area1, area2), area3) / 2;
            total += area1 + area2 + area3 + slack;
        }
        return total;
    }

    public int getTotalLength(List<List<Integer>> listOfDimensions){
        int total = 0;
        for (List<Integer> dimensions : listOfDimensions){
            List<Integer> list = dimensions.stream().sorted().toList();
            int length = (2 * list.get(0)) + (2 * list.get(1));
            int bow = dimensions.get(0) * dimensions.get(1) * dimensions.get(2);
            total += length + bow;
        }
        return total;
    }
}
