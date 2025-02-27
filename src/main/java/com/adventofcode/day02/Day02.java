package com.adventofcode.day02;

import java.util.List;

public class Day02 {

    private int length;
    private int height;
    private int width;

    public int getTotalSquareFeet(List<List<Integer>> listOfDimensions) {
        int total = 0;
        for (List<Integer> dimensions : listOfDimensions){
            updateDimensions(dimensions);
            int area1 = 2 * length * width;
            int area2 = 2 * width * height;
            int area3 = 2 * height * length;
            int slack = Math.min(Math.min(area1, area2), area3) / 2;
            total += area1 + area2 + area3 + slack;
        }
        return total;
    }

    private void updateDimensions(List<Integer> dimensions){
        this.length = dimensions.get(0);
        this.height = dimensions.get(1);
        this.width = dimensions.get(2);
    }
}
