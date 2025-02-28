package com.adventofcode.day05;

import java.util.List;
import java.util.Map;

public class Day05 {

    private static final String THREE_VOWELS_PATTERN = "(\\w*[aeiou]\\w*){3}";
    private static final String ONE_LETTER_TWICE_IN_ROW_PATTERN = "\\b\\w*(\\w)\\1\\w*\\b";
    private static final String NO_BANNED_WORDS_PATTERN = "^(?!.*(ab|cd|pq|xy)).*$";
    private static final String PAIR_LETTERS_TWICE_WITHOUT_OVERLAPPING = ".*([a-zA-Z]{2}).*\\1.*";
    private static final String A_B_A_PATTERN = ".*([a-z])\\w(\\1).*";

    private static final Map<CheckingMethod, List<String>> RULES = Map.of(
            CheckingMethod.STANDARD, List.of(THREE_VOWELS_PATTERN, ONE_LETTER_TWICE_IN_ROW_PATTERN, NO_BANNED_WORDS_PATTERN),
            CheckingMethod.BETTER, List.of(PAIR_LETTERS_TWICE_WITHOUT_OVERLAPPING, A_B_A_PATTERN)
    );

    public int howManyStringsAreNice(List<String> list, CheckingMethod method) {
        return (int) list.stream()
                .filter(word -> isNice(word, method))
                .count();
    }

    private boolean isNice(String word, CheckingMethod method) {
        return RULES.getOrDefault(method, List.of())
                .stream()
                .allMatch(word::matches);
    }
}
