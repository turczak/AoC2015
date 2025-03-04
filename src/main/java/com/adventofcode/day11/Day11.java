package com.adventofcode.day11;

import java.util.Arrays;
import java.util.List;

public class Day11 {

    private static final List<Character> BANNED_LETTERS = Arrays.asList('i', 'o', 'l');
    private static final String TWO_DIFFERENT_NON_OVERLAPPING_PAIRS = "(?:([a-z])\\1.*([a-z])\\2|[a-z]*([a-z])\\3[a-z]*){2,}";

    public String generateNewPassword(String oldPassword) {
        String newPassword = oldPassword;
        do {
            newPassword = incrementPassword(newPassword);
        } while (!checkIfValid(newPassword));
        return newPassword;
    }

    private boolean checkIfValid(String password) {
        return increasingStraightOfThreeLetters(password) && !checkIfContainsBannedLetters(password) && password.matches(TWO_DIFFERENT_NON_OVERLAPPING_PAIRS);
    }

    private boolean increasingStraightOfThreeLetters(String password) {
        for (int i = 0; i < password.length() - 2; i++) {
            char first = password.charAt(i);
            char second = (char) (first + 1);
            char third = (char) (first + 2);
            if (password.charAt(i + 1) == second && password.charAt(i + 2) == third) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfContainsBannedLetters(String password) {
        return password.chars()
                .mapToObj(letter -> (char) letter)
                .anyMatch(BANNED_LETTERS::contains);
    }

    private String incrementPassword(String password) {
        char[] chars = password.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == 'z') {
                chars[i] = 'a';
            } else {
                chars[i] = (char) (chars[i] + 1);
                break;
            }
        }
        return new String(chars);
    }
}
