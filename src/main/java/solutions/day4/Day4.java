package solutions.day4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4 {
    private String secretKey = "yzbqklnj";

    private String calculateMD5(String input) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = md5.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b:
        bytes){
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public int findLowestPossibleNumber(String requirement) throws NoSuchAlgorithmException {
        int number = 1;
        while (true){
            String hash = calculateMD5(secretKey + number);
            if(hash.startsWith(requirement)) return number;
            number++;
        }
    }
}
