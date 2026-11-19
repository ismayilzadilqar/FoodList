import java.util.ArrayList;

public class OrderService {

    private ArrayList<Food> selectedFoods = new ArrayList<>();

    private FoodService foodService;

    public OrderService(FoodService foodService) {
        this.foodService = foodService;
    }

    public void addToOrder(int foodId) {

        Food food = foodService.getFoodById(foodId);

        if (food == null) {
            System.out.println("Bu ID ilə yemək tapılmadı!");
            return;
        }

        selectedFoods.add(food);

        System.out.println(food.getName() + " sifarişə əlavə edildi!");
    }

    public void showSelectedFoods() {

        if (selectedFoods.isEmpty()) {
            System.out.println("Sifariş siyahısı boşdur!");
            return;
        }

        System.out.println("\n--- SİFARİŞ SİYAHISI ---");

        double total = 0;

        for (Food food : selectedFoods) {
            System.out.println(food);

            total += food.getPrice();
        }

        System.out.println("-----------------------");
        System.out.println("Ümumi məbləğ: " + total + " AZN");
    }
}