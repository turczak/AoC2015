package com.adventofcode.day05;

import java.util.List;

public class Day05 {

    public int howManyStringsAreNice(List<String> list) {
        return list.stream()
                .filter(this::isNice)
                .toList()
                .size();
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

    private boolean isNice(String word) {
        return isContainsThreeVowels(word) && isContainsOneLetterTwiceInRow(word) && isContainBannedStrings(word);
    }
}
