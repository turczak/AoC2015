package solutions.day12;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;
import java.io.IOException;

public class Day12 {
    private final File file;
    public Day12(File file) {
        this.file = file;
    }

    public void run() throws IOException {
        JsonParser parser = new JsonFactory().createParser(file);
        System.out.println("Sum of all integers in json file: " + calculateSum(parser));
    }

    private int calculateSum(JsonParser parser) throws IOException {
        int sum = 0;
        while (parser.nextToken() != null) {
            JsonToken token = parser.getCurrentToken();
            if (JsonToken.VALUE_NUMBER_INT.equals(token)) sum += parser.getIntValue();
            else if (JsonToken.START_ARRAY.equals(token)) sum += calculateSum(parser);
            else if (JsonToken.START_OBJECT.equals(token)) sum += calculateSum(parser);
        }
        return sum;
    }
}
