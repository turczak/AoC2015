package com.adventofcode.day05;

import java.util.List;

public class Day05 {

    private static final String THREE_VOWELS_PATTERN = "(\\w*[aeiou]\\w*){3}";
    private static final String ONE_LETTER_TWICE_IN_ROW_PATTERN = "\\b\\w*(\\w)\\1\\w*\\b";
    private static final String NO_BANNED_WORDS_PATTERN = "^(?!.*(ab|cd|pq|xy)).*$";
    private static final String PAIR_LETTERS_TWICE_WITHOUT_OVERLAPPING = ".*([a-zA-Z]{2}).*\\1.*";
    private static final String A_B_A_PATTERN = ".*([a-z])\\w(\\1).*";

    public int howManyStringsAreNice(List<String> list, CheckingMethod method) {
        return list.stream()
                .filter(word -> isNice(word, method))
                .toList()
                .size();
    }

    private boolean isNice(String word, CheckingMethod method) {
        return switch (method) {
            case STANDARD ->
                    word.matches(THREE_VOWELS_PATTERN) && word.matches(ONE_LETTER_TWICE_IN_ROW_PATTERN) && word.matches(NO_BANNED_WORDS_PATTERN);
            case BETTER -> word.matches(PAIR_LETTERS_TWICE_WITHOUT_OVERLAPPING) && word.matches(A_B_A_PATTERN);
            case null -> false;
        };
    }

}
