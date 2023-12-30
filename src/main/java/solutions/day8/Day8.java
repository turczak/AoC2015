package solutions.day8;

import java.util.List;

public class Day8 {
    private int totalNumberOfChars = 0;
    private int totalNumberOfChars_encoded = 0;
    private int totalNumberOfCharsInMemory = 0;
    private int partI = 0;
    private int partII = 0;

    public void run(List<String> list) {
        for (String line :
                list) {
            count(line);
        }
        partI = totalNumberOfChars - totalNumberOfCharsInMemory;
        partII = totalNumberOfChars_encoded - totalNumberOfChars;
    }

    private void count(String line) {
        int num_chars_mem = 0;
        int num_chars_encoded = 6;
        char[] chars = line.toCharArray();
        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i] == '\\') {
                num_chars_encoded += 2;
                switch (chars[i + 1]) {
                    case '\\', '\"' -> {
                        i++;
                        num_chars_encoded += 2;
                    }
                    case 'x' -> {
                        i += 3;
                        num_chars_encoded += 3;
                    }
                }
            }else{
                num_chars_encoded++;
            }
            num_chars_mem++;
        }
        totalNumberOfChars += line.length();
        totalNumberOfCharsInMemory += num_chars_mem;
        totalNumberOfChars_encoded += num_chars_encoded;
    }
    @Override
    public String toString() {
        return "Day8" +
                "\n part I = " + partI +
                "\n totalNumberOfChars = " + totalNumberOfChars +
                "\n totalNumberOfCharsInMemory = " + totalNumberOfCharsInMemory +
                "\n part II = " + partII +
                "\n totalNumberOfChars_encoded = " + totalNumberOfChars_encoded;
    }
}
