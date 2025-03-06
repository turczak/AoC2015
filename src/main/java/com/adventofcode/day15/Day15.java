package com.adventofcode.day15;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day15 {
    public static final int MAX_TEASPOONS = 100;
    private static final String REGEX = ": capacity |, durability |, flavor |, texture |, calories ";
    private final Set<Ingredient> ingredients = new HashSet<>();

    public Day15(List<String> input) {
        input.forEach(line -> addIngredient((line.split(REGEX))));
    }

    public int run() {
        Recipe recipe = new Recipe();
        recipe.findBestRecipe(ingredients, ingredients.size());
        System.out.println(recipe);
        return 0;
    }

    private void addIngredient(String[] split) {
        ingredients.add(new Ingredient(split[0],
                Integer.parseInt(split[1]),
                Integer.parseInt(split[2]),
                Integer.parseInt(split[3]),
                Integer.parseInt(split[4]),
                Integer.parseInt(split[5])));
    }
}
