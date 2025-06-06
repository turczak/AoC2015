package com.adventofcode.day15;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day15 {
    private final Pattern pattern = Pattern.compile(
            "^(?<name>\\w+): " +
                    "capacity (?<capacity>-?\\d+), " +
                    "durability (?<durability>-?\\d+), " +
                    "flavor (?<flavor>-?\\d+), " +
                    "texture (?<texture>-?\\d+), " +
                    "calories (?<calories>-?\\d+)");
    private final Set<Ingredient> ingredients = new HashSet<>();

    public Day15(List<String> input) {
        input.forEach(this::addIngredient);
    }

    public int run() {
        Recipe recipe = new Recipe();
        recipe.findBestRecipe(ingredients, ingredients.size());
        System.out.println(recipe);
        return 0;
    }

    private void addIngredient(String line) {
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            String name = matcher.group("name");
            int capacity = Integer.parseInt(matcher.group("capacity"));
            int durability = Integer.parseInt(matcher.group("durability"));
            int flavor = Integer.parseInt(matcher.group("flavor"));
            int texture = Integer.parseInt(matcher.group("texture"));
            int calories = Integer.parseInt(matcher.group("calories"));
            ingredients.add(new Ingredient(name, capacity, durability, flavor, texture, calories));
        }
    }
}
