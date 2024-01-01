package solutions.day10;

public class Day10 {
    public int run(String original, int n){
        String result = original;
        while (n > 0){
            result = lookAndSay(result);
            n--;
        }
        return result.length();
    }

    private String lookAndSay(String input){
        StringBuilder result = new StringBuilder();
        int counter = 1;
        for (int i = 0; i < input.length(); i++) {
            if(i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)){
                counter++;
            }else {
                result.append(counter).append(input.charAt(i));
                counter = 1;
            }
        }
        return result.toString();
    }
}
