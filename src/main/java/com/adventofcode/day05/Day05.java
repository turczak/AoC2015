package com.adventofcode.day05;

import java.util.List;

public class Day05 {

    public int howManyStringsAreNice(List<String> list, MethodOfCheckingIfStringIsNice method) {
        return list.stream()
                .filter(word -> isNice(word, method))
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

    private boolean isContainPairOfLettersTwiceWithoutOverlapping(String word) {
        return word.matches(".*([a-zA-Z]{2}).*\\1.*");
    }

    //check if it contains at least one letter which repeats with exactly one letter between them
    private boolean isContainsPatternAbA(String word) {
        return word.matches(".*([a-z])\\w(\\1).*");
    }

    private boolean isNice(String word, MethodOfCheckingIfStringIsNice method) {
        return switch (method) {
            case STANDARD ->
                    isContainsThreeVowels(word) && isContainsOneLetterTwiceInRow(word) && isContainBannedStrings(word);
            case BETTER -> isContainPairOfLettersTwiceWithoutOverlapping(word) && isContainsPatternAbA(word);
            case null -> false;
        };
    }
}
