package com.adventofcode.day12;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;
import java.io.IOException;

public class Day12 {
    private final JsonParser parser;

    public Day12(File file) {
        try {
            parser = new JsonFactory().createParser(file);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public int calculateSum() {
        int sum = 0;
        try {
            while (parser.nextToken() != null) {
                JsonToken token = parser.getCurrentToken();
                switch (token) {
                    case JsonToken.VALUE_NUMBER_INT -> sum += parser.getIntValue();
                    case JsonToken.START_ARRAY, JsonToken.START_OBJECT -> sum += calculateSum();
                }
            }
            return sum;
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
