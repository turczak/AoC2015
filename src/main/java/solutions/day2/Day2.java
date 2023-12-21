package solutions.day2;

import java.util.HashMap;
import java.util.List;

public class Day2 {
    public Integer calculateTotalSquareFeet(List<List<Integer>> lists){
        Integer result = 0;
        for (List<Integer> list:
        lists){
            result += new Present(list).getTotalArea();
        }
        return result;
    }
}
