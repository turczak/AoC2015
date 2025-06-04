package com.adventofcode.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Recipe {
    private Map<Ingredient, Integer> bestRecipe;
    private Integer maxScore = 0;
    private Integer counter = 0;

    public Recipe() {
        bestRecipe = new HashMap<>(Day15.MAX_TEASPOONS);
    }

    private void generateAllRecipes(Ingredient[] chosen, List<Ingredient> arr,
                                    int index, int r, int start, int end) {
        if (index == r) {
            counter++;
            HashMap<Ingredient, Integer> recipe = convertRecipe(Arrays.asList(chosen).subList(0, r));
            Integer score = calculateScore(recipe);
            if (score > maxScore) {
                maxScore = score;
                bestRecipe = recipe;
            }
            return;
        }

        for (int i = start; i <= end; i++) {
            chosen[index] = arr.get(i);
            generateAllRecipes(chosen, arr, index + 1, r, i, end);
        }
    }

    public void findBestRecipe(Set<Ingredient> ingredients, int n) {
        Ingredient[] chosen = new Ingredient[100];
        generateAllRecipes(chosen, new ArrayList<>(ingredients), 0, Day15.MAX_TEASPOONS, 0, n - 1);
    }

    private Integer calculateScore(HashMap<Ingredient, Integer> recipe) {
        int totalCapacity = 0;
        int totalDurability = 0;
        int totalFlavor = 0;
        int totalTexture = 0;
        int totalCalories = 0;

        for (Map.Entry<Ingredient, Integer> entry : recipe.entrySet()) {
            Ingredient key = entry.getKey();
            totalCapacity += key.capacity() * entry.getValue();
            totalDurability += key.durability() * entry.getValue();
            totalFlavor += key.flavor() * entry.getValue();
            totalTexture += key.texture() * entry.getValue();
            totalCalories += key.calories() * entry.getValue();
        }

        if (totalCapacity <= 0 || totalDurability <= 0 || totalFlavor <= 0 || totalTexture <= 0) {
            return 0;
        } else if (totalCalories == 500) {
            return totalCapacity * totalDurability * totalFlavor * totalTexture;
        } else {
            return 0;
        }
    }

    private HashMap<Ingredient, Integer> convertRecipe(List<Ingredient> recipeAsList) {
        return new HashMap<>() {
            {
                for (Ingredient ingredient : recipeAsList)
                    this.merge(ingredient, 1, Integer::sum);
            }
        };
    }

    @Override
    public String toString() {
        return "Score: " + maxScore +
                "\nBest recipe: " + bestRecipe +
                "\nGenerated recipes: " + counter;
    }
}
