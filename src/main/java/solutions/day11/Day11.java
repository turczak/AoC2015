package solutions.day11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day11 {
    private Matcher matcher;

    public String generateNewPassword(String oldPassword) {
        String result = oldPassword;
        while (!check(result)) {
            result = increamentPassword(result);
        }
        return result;
    }

    private boolean check(String password) {
        return first(password) && second(password) && third(password);
    }

    public boolean first(String password) {
        for (int i = 0; i < password.length() - 2; i++) {
            char first = password.charAt(i);
            char second = (char) (first + 1);
            char third = (char) (first + 2);
            if (password.charAt(i + 1) == second && password.charAt(i + 2) == third) return true;
        }
        return false;
    }

    public boolean second(String password) {
        String regex = "(?:(?![iol]).)*";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(password).matches();
    }

    public boolean third(String password) {
        String regex = "(?:([a-z])\\1.*([a-z])\\2|[a-z]*([a-z])\\3[a-z]*){2,}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(password).matches();
    }

    private String increamentPassword(String password) {
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
