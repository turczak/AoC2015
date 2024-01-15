package solutions.day15;

import utils.MyFileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Day15 {

    private static final int MAX_TEASPOONS = 100;

    private static Set<Ingredient> initializeIngredients(List<String> input) {
        HashSet<Ingredient> ingredients = new HashSet<>();
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
        return ingredients;
    }

    public static void main(String[] args) throws FileNotFoundException {

        MyFileReader reader = new MyFileReader(new File("src/main/resources/day15.txt"));
        Set<Ingredient> ingredients = initializeIngredients(reader.inputAsListOfStrings());

        Recipe recipe = new Recipe() {
            {
                findBestRecipe(ingredients, ingredients.size(), MAX_TEASPOONS);
            }
        };
        System.out.println(recipe);
    }
}
