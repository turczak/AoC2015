package com.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class CustomFileReader {

    private Scanner scanner;
    private File file;

    public CustomFileReader(File file) {
        this.file = file;
        try {
            this.scanner = new Scanner(file);
        } catch (FileNotFoundException exception) {
            throw new RuntimeException("File not found: " + file.getAbsolutePath(), exception);
        }
    }

    public List<Character> inputAsListOfCharacters() {
        return scanner.next().chars().mapToObj(c -> (char) c).toList();
    }
}
