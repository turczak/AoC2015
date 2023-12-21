package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class MyFileReader {
    private Scanner scanner;
    private File file;

    public MyFileReader(File file) throws FileNotFoundException {
        this.file = file;
        this.scanner = new Scanner(file);
    }
    public void changeFile(File file) throws FileNotFoundException {
        this.file = file;
        this.scanner = new Scanner(file);
    }

    public List<Character> inputAsListOfCharacters(){
        return scanner.next().chars().mapToObj(c -> (char) c).toList();
    }
}
