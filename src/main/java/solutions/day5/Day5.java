package solutions.day5;

import java.util.List;

public class Day5 {
    private List<String> list;
    public Day5(List<String> list){
        this.list = list;
    }
    private boolean isContainsThreeVowels(String word){
        return word.matches("(\\w*[aeiou]\\w*){3}");
    }

    private boolean isOneLetterTwiceInRow(String word){
        return word.matches("\\b\\w*(\\w)\\1\\w*\\b");
    }

    private boolean isContainBannedStrings(String word){
        return word.matches("^(?!.*(ab|cd|pq|xy)).*$");
    }

    private boolean isValid(String word){
        return isContainsThreeVowels(word) && isOneLetterTwiceInRow(word) && isContainBannedStrings(word);
    }

    public int howManyStringsAreValid(){
        int counter = 0;
        for (String s:
        list)
            if (isValid(s)) counter++;
        return counter;
    }
}