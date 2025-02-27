package com.adventofcode.day04;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day04 {
    private final String secretKey = "yzbqklnj";

    private String calculateMD5(String input) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException exception) {
            throw new RuntimeException("Algorithm not found.", exception);
        }
    }

    public int findLowestPossibleNumber(String requirement) {
        for (int number = 1; ; number++) {
            String hash = calculateMD5(secretKey + number);
            if (hash.startsWith(requirement)) {
                return number;
            }
        }
    }
}
