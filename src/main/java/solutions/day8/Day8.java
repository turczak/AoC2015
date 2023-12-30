package solutions.day8;

import java.util.List;

public class Day8 {
    private int totalNumberOfChars = 0;
    private int totalNumberOfCharsInMemory = 0;
    private int result = 0;

    public void run(List<String> list) {
        for (String line :
                list) {
            checkLine(line);
        }
        result = totalNumberOfChars - totalNumberOfCharsInMemory;
    }

    private int countCharsInMemory(String line) {
        int num_chars_mem = 0;
        char[] chars = line.toCharArray();
        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i] == '\\') {
                switch (chars[i + 1]) {
                    case '\\', '\"' -> i++;
                    case 'x' -> i += 3;
                }
            }
            num_chars_mem++;
        }
        return num_chars_mem;
    }

    private void checkLine(String line) {
        totalNumberOfChars += line.length();
        totalNumberOfCharsInMemory += countCharsInMemory(line);
    }

    @Override
    public String toString() {
        return "Day8{" +
                "result=" + result +
                ", totalNumberOfChars=" + totalNumberOfChars +
                ", totalNumberOfCharsInMemory=" + totalNumberOfCharsInMemory +
                '}';
    }
}
