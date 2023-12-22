package solutions.day5;

import java.util.List;

public class Day5 {
    private List<String> list;
    private Integer counter_v1;
    private Integer counter_v2;

    public Day5(List<String> list) {
        this.list = list;
        this.counter_v1 = 0;
        this.counter_v2 = 0;
        howManyStringsAreValid();
    }

    public Integer getCounter_v1() {
        return counter_v1;
    }

    public Integer getCounter_v2() {
        return counter_v2;
    }

    private boolean isContainsThreeVowels(String word) {
        return word.matches("(\\w*[aeiou]\\w*){3}");
    }

    private boolean isContainsOneLetterTwiceInRow(String word) {
        return word.matches("\\b\\w*(\\w)\\1\\w*\\b");
    }

    private boolean isContainBannedStrings(String word) {
        return word.matches("^(?!.*(ab|cd|pq|xy)).*$");
    }

    private boolean isContainPairOfLettersTwiceWithoutOverlapping(String word) {
        return word.matches(".*([a-zA-Z]{2}).*\\1.*");
    }

    //check if it contains at least one letter which repeats with exactly one letter between them
    private boolean isContainsPatternAbA(String word) {
        return word.matches(".*([a-z])\\w(\\1).*");
    }

    private boolean isValid_v1(String word) {
        return isContainsThreeVowels(word) && isContainsOneLetterTwiceInRow(word) && isContainBannedStrings(word);
    }

    private boolean isValid_v2(String word) {
        return isContainPairOfLettersTwiceWithoutOverlapping(word) && isContainsPatternAbA(word);
    }

    private void howManyStringsAreValid() {
        for (String s :
                list) {
            if (isValid_v1(s)) counter_v1++;
            if (isValid_v2(s)) counter_v2++;
        }
    }
}