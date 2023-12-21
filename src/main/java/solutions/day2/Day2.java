package solutions.day2;

import java.util.HashMap;
import java.util.List;

public class Day2 {

    private Integer totalSquareFeet = 0, totalLengthOfRibbon = 0;

    public Day2(List<List<Integer>> lists){
        calculateResults(lists);
    }
    private void calculateResults(List<List<Integer>> lists){
        for (List<Integer> list:
        lists){
            Present present = new Present(list);
            totalSquareFeet += present.getTotalArea();
            totalLengthOfRibbon += present.getTotalLength();
        }
    }
    public Integer getTotalSquareFeet() {
        return totalSquareFeet;
    }
    public Integer getTotalLengthOfRibbon() {
        return totalLengthOfRibbon;
    }
}
