package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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

    public List<List<Integer>> inputAsListOfListsOfDimenions(){
        List<List<Integer>> list = new ArrayList<>();
        while (scanner.hasNextLine()){
            List<Integer> subList = new ArrayList<>();
            String[] xes = scanner.nextLine().split("x");
            for (String s:
            xes){
                subList.add(Integer.parseInt(s));
            }
            list.add(subList);
        }
        return list;
    }

    public List<String> inputAsListOfStrings(){
        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()){
            list.add(scanner.nextLine());
        }
        return list;
    }
}
