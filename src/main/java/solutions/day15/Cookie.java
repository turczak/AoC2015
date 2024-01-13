package solutions.day15;

import java.util.*;

public class Cookie {
    private final Recipe recipe;
    private final Integer score;

    public Cookie(Set<Ingredient> ingredients, int maxTeaspoons) {
        recipe = new Recipe(ingredients, maxTeaspoons);
        score = recipe.getMaxScore();
    }

    public void show(){
        System.out.println(recipe.getBestRecipe());
        System.out.println("Score : " + score);
    }
}