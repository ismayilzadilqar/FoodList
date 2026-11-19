import java.util.ArrayList;

public class FoodService {

    private FoodRepository repository;

    public FoodService(FoodRepository repository) {
        this.repository = repository;
    }

    public void addFood(String name, double price) {

        if (name == null || name.trim().isEmpty() || price <= 0) {
            System.out.println("Yanlış yemək məlumatları!");
            return;
        }

        int id = repository.getNextId();

        Food food = new Food(id, name, price);

        repository.add(food);

        System.out.println("Yemək uğurla əlavə edildi!");
    }

    public ArrayList<Food> getAllFoods() {
        return repository.findAll();
    }

    public Food getFoodById(int id) {
        return repository.findById(id);
    }

    public void showAllFoods() {

        for (Food food : repository.findAll()) {
            System.out.println(food);
        }
    }
}