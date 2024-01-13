package solutions.day15;

public record Ingredient(String name, int capacity, int durability, int flavor, int texture, int calories) {

    @Override
    public String toString() {
        return '[' + name + ']';

    }
}
