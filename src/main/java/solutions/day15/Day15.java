package solutions.day15;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day15 {
    private final Set<Ingredient> ingredients;

    public Day15(List<String> input) {
        ingredients = new HashSet<>();
        initializeIngredients(input);
    }
    public void run(){
        Cookie cookie = new Cookie(ingredients, 5);
        cookie.show();
    }
    private void initializeIngredients(List<String> input) {
        for (String line :
                input) {
            String[] split = line.split(": capacity |, durability |, flavor |, texture |, calories ");
            String name = split[0];
            int capacity = Integer.parseInt(split[1]);
            int durability = Integer.parseInt(split[2]);
            int flavor = Integer.parseInt(split[3]);
            int texture = Integer.parseInt(split[4]);
            int calories = Integer.parseInt(split[5]);
            Ingredient ingredient = new Ingredient(name, capacity, durability, flavor, texture, calories);
            ingredients.add(ingredient);
        }
    }
}


