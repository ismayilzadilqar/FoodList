import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        FoodRepository repository = new FoodRepository();

        FoodService foodService = new FoodService(repository);

        OrderService orderService = new OrderService(foodService);


        foodService.addFood("Burger", 8.50);
        foodService.addFood("Pizza", 12.00);
        foodService.addFood("Lahmacun", 5.00);
        foodService.addFood("Dönər", 6.00);
        foodService.addFood("Kartof fri", 4.00);
        foodService.addFood("Hot Dog", 5.50);
        foodService.addFood("Salat", 7.00);
        foodService.addFood("Kabab", 15.00);


        while (true) {

            System.out.println("\n===== FOODLIST =====");
            System.out.println("1. Bütün yeməkləri göstər");
            System.out.println("2. Yemək ID ilə axtar");
            System.out.println("3. Sifarişə yemək əlavə et");
            System.out.println("4. Sifariş siyahısını göstər");
            System.out.println("5. Yeni yemək əlavə et");
            System.out.println("0. Çıxış");

            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    foodService.showAllFoods();
                    break;

                case 2:
                    System.out.print("Yemək ID daxil edin: ");
                    int searchId = scanner.nextInt();

                    Food food = foodService.getFoodById(searchId);

                    if (food != null) {
                        System.out.println(food);
                    } else {
                        System.out.println("Yemək tapılmadı!");
                    }
                    break;

                case 3:
                    System.out.print("Yemək ID daxil edin: ");
                    int orderId = scanner.nextInt();

                    orderService.addToOrder(orderId);
                    break;

                case 4:
                    orderService.showSelectedFoods();
                    break;

                case 5:
                    System.out.print("Yeməyin adı: ");
                    String name = scanner.nextLine();

                    System.out.print("Yeməyin qiyməti: ");
                    double price = scanner.nextDouble();

                    foodService.addFood(name, price);
                    break;

                case 0:
                    System.out.println("FoodList proqramından çıxıldı!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Yanlış seçim!");
            }
        }
    }
}