package com.adventofcode.day12;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;
import java.io.IOException;

public class Day12 {

    public int run(File file) {
        try {
            JsonParser parser = new JsonFactory().createParser(file);
            return calculateSum(parser);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private int calculateSum(JsonParser parser) {
        int sum = 0;
        try {
            while (parser.nextToken() != null) {
                JsonToken token = parser.getCurrentToken();
                if (JsonToken.VALUE_NUMBER_INT.equals(token)) {
                    sum += parser.getIntValue();
                }
                if (JsonToken.START_ARRAY.equals(token)) {
                    sum += calculateSum(parser);
                }
                if (JsonToken.START_OBJECT.equals(token)) {
                    sum += calculateSum(parser);
                }
            }
            return sum;
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
