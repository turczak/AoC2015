package solutions.day7;

import java.util.HashMap;
import java.util.List;

public class Day7 {
    private HashMap<String, Short> hashMap;
    private List<String> list;
    public Day7(List<String> input){
        this.list = input;
        this.hashMap = new HashMap<>();
    }

    private void createCommand(String line){
        String[] split = line.split(" ");
        if(split.length == 3){
            //TODO command to assign value/wire.value() to wire
        }
        if(split.length == 4){
            //TODO NOT left wire and assign given value to right wire
        }
        if(split.length == 5){
            String action = split[1];
            switch (action){
                case "AND" -> //TODO;
                case "OR" -> //TODO;
                case "LSHIFT" -> //TODO;
                case "RSHIFT" -> //TODO;
            }
        }

    }
}