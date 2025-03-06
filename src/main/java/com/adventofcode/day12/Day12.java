package com.adventofcode.day12;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;
import java.io.IOException;

public class Day12 {
    private final JsonFactory factory = new JsonFactory();

    public int calculateSum(File file) {
        try (JsonParser parser = factory.createParser(file)) {
            int sum = 0;
            while (parser.nextToken() != null) {
                if (parser.getCurrentToken() == JsonToken.VALUE_NUMBER_INT) {
                    sum += parser.getIntValue();
                }
            }
            return sum;
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
