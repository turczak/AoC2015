package solutions.day15;

import java.util.*;

public class Recipe {

    private List<Ingredient> bestRecipe;
    private Integer maxScore;

    public Recipe(Set<Ingredient> ingredients, int maxTeaspoons) {
        bestRecipe = new ArrayList<>();
        maxScore = 0;
        generateAllRecipes(ingredients, maxTeaspoons, new ArrayList<>());
    }

    private void generateAllRecipes(Set<Ingredient> ingredients, int size, List<Ingredient> currentRecipe) {
        if (size == 0) {
            Integer currentScore = calculateScore(convertRecipe(currentRecipe));
            if (currentScore >= maxScore) {
                maxScore = currentScore;
                bestRecipe = new ArrayList<>(currentRecipe);
            }
            return;
        }

        for (Ingredient ingredient : ingredients) {
            currentRecipe.add(ingredient);
            generateAllRecipes(ingredients, size - 1, currentRecipe);
            currentRecipe.remove(currentRecipe.size() - 1);
        }
    }

    private Integer calculateScore(HashMap<Ingredient, Integer> recipe) {
        int totalCapacity = 0;
        int totalDurability = 0;
        int totalFlavor = 0;
        int totalTexture = 0;

        for (Map.Entry<Ingredient, Integer> entry :
                recipe.entrySet()) {
            Ingredient key = entry.getKey();
            totalCapacity += key.capacity() * entry.getValue();
            totalDurability += key.durability() * entry.getValue();
            totalFlavor += key.flavor() * entry.getValue();
            totalTexture += key.texture() * entry.getValue();
        }

        if (totalCapacity <= 0 | totalDurability <= 0 | totalFlavor <= 0 | totalTexture <= 0) return 0;
        else return totalCapacity * totalDurability * totalFlavor * totalTexture;
    }

    private HashMap<Ingredient, Integer> convertRecipe(List<Ingredient> recipeAsList) {
        return new HashMap<>() {
            {
                for (Ingredient ingredient :
                        recipeAsList)
                    this.merge(ingredient, 1, Integer::sum);
            }
        };
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public HashMap<Ingredient, Integer> getBestRecipe() {
        return convertRecipe(bestRecipe);
    }

}




