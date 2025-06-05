package com.adventofcode.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Recipe {
    private final int AMOUNT_OF_TEASPOONS = 100;
    private Map<Ingredient, Integer> bestRecipe;
    private Integer maxScore = 0;
    private Integer generatedRecipes = 0;

    public Recipe() {
        bestRecipe = new HashMap<>(AMOUNT_OF_TEASPOONS);
    }

    private void generateAllRecipes(Ingredient[] chosen, List<Ingredient> arr,
                                    int index, int start, int end) {
        if (index == AMOUNT_OF_TEASPOONS) {
            generatedRecipes++;
            HashMap<Ingredient, Integer> recipe = convertRecipe(Arrays.asList(chosen).subList(0, AMOUNT_OF_TEASPOONS));
            Integer score = calculateScore(recipe);
            if (score > maxScore) {
                maxScore = score;
                bestRecipe = recipe;
            }
            return;
        }

        for (int i = start; i <= end; i++) {
            chosen[index] = arr.get(i);
            generateAllRecipes(chosen, arr, index + 1, i, end);
        }
    }

    public void findBestRecipe(Set<Ingredient> ingredients, int n) {
        Ingredient[] chosen = new Ingredient[100];
        generateAllRecipes(chosen, new ArrayList<>(ingredients), 0, 0, n - 1);
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
        }
        if (totalCalories == 500) {
            return totalCapacity * totalDurability * totalFlavor * totalTexture;
        }
        return 0;
    }

    private HashMap<Ingredient, Integer> convertRecipe(List<Ingredient> recipeAsList) {
        return recipeAsList.stream()
                .collect(Collectors.toMap(
                        ingredient -> ingredient,
                        ingredient -> 1,
                        Integer::sum,
                        HashMap::new
                ));
    }

    @Override
    public String toString() {
        return "Recipe{\n" +
                "amountOfTeaspoons=" + AMOUNT_OF_TEASPOONS +
                ", \nbestRecipe=" + bestRecipe +
                ", \nmaxScore=" + maxScore +
                ", \ncounter=" + generatedRecipes +
                '}';
    }
}
