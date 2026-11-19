import java.util.ArrayList;

public class FoodRepository {

    private ArrayList<Food> foods = new ArrayList<>();

    public void add(Food food) {
        foods.add(food);
    }

    public ArrayList<Food> findAll() {
        return foods;
    }

    public Food findById(int id) {

        for (Food food : foods) {
            if (food.getId() == id) {
                return food;
            }
        }

        return null;
    }

    public int getNextId() {
        return foods.size() + 1;
    }
}