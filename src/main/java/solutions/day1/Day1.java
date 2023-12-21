package solutions.day1;

import java.util.List;

public class Day1 {
    public int calculateFloor(List<Character> inputList){
        int floor = 0;
        for (Character c:
        inputList){
            if(c == '('){
                floor++;
            } else if (c == ')') {
                floor--;
            }
        }
        return floor;
    }
    public int findPositionOfCharacter(List<Character> inputList){
        int floor = 0;
        int position = 0;
        while (floor != -1){
            if(inputList.get(position) == '('){
                floor++;
            } else if (inputList.get(position) == ')') {
                floor--;
            }
            position++;
        }
        return position;
    }

}
