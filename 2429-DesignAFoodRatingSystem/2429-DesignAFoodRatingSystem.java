// Last updated: 1/19/2026, 10:45:27 PM
import java.util.*;

public class FoodRatings {

    static class Food {
        String name;
        String cuisine;
        int rating;

        Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    private final Map<String, Food> foodMap = new HashMap<>();
    private final Map<String, TreeSet<Food>> cuisineMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

        Comparator<Food> cmp = (a, b) -> {
            if (a.rating != b.rating) {
                return b.rating - a.rating; // higher rating first
            }
            return a.name.compareTo(b.name); // lexicographically smaller first
        };

        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], food);

            cuisineMap
                .computeIfAbsent(cuisines[i], k -> new TreeSet<>(cmp))
                .add(food);
        }
    }

    public void changeRating(String foodName, int newRating) {
        Food food = foodMap.get(foodName);
        TreeSet<Food> set = cuisineMap.get(food.cuisine);

        // critical: remove → update → reinsert
        set.remove(food);
        food.rating = newRating;
        set.add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).first().name;
    }
}


/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */