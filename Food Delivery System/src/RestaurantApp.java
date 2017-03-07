import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yilin on 3/4/2017.
 */
public class RestaurantApp {
    public static void main(String [] args){
        System.out.println("Welcome to Restaurant App !");
        User user = new User("Yilin", "4292 Albany Dr, San Jose, CA");
        List<Restaurant> restaurants = createRestaurants();

        RestaurantService restaurantService = new RestaurantService(restaurants);
        MenuService menuService = new MenuService();
        OrderService orderService = new OrderService();
        ReviewService reviewService = new ReviewService();

        // User searching restaurants
        List<Restaurant> matchedRestaurant= restaurantService.queryRestaurantByName("Shanghai");
        Restaurant chosenRestaurant = matchedRestaurant.get(0);

        // User querying menu
        List<MenuItem> menuItems = menuService.queryMenu(chosenRestaurant, "Lunch");

        // User make a order
        List<MenuItem> orderedItems = new ArrayList<>();
        orderedItems.add(menuItems.get(0));
        orderedItems.add(menuItems.get(1));
        Order order = orderService.placeOrder(user, orderedItems);
        orderService.getOrderStatus(user);
        orderService.getTotal(order);
        orderService.updateOrderStatus(order, OrderStatus.ON_DELIVERY);
        orderService.getOrderStatus(user);

        // Food delivered
        System.out.println("... Delivering ...");
        orderService.updateOrderStatus(order, OrderStatus.COMPLETED);
        orderService.getOrderStatus(user);

        // User write a review for this restaurant
        reviewService.makeReview(user, chosenRestaurant, "Sweet and Soy Rib is very yummy !!!");
        reviewService.makeReview(user, matchedRestaurant.get(1), "Doesn't look good .");
        reviewService.getReviewByRestaurant(chosenRestaurant);
        reviewService.getReviewByRestaurant(matchedRestaurant.get(1));
        reviewService.getReviewByUser(user);

    }

    private static List<Restaurant> createRestaurants(){
        List<Restaurant> restaurants = new ArrayList<>();

        Restaurant restaurant1 = new Restaurant("Sichuan Spicy", "San Jose", "408123456");
        Restaurant restaurant2 = new Restaurant("Shanghai Family", "Milpitas", "408987654");
        Restaurant restaurant3 = new Restaurant("Dongbei Food", "Cuputino", "40867890");
        Restaurant restaurant4 = new Restaurant("Shanghai House", "Fremont", "40800000");

        restaurant1.setMenus(createMenus(restaurant1.getName()));
        restaurant2.setMenus(createMenus(restaurant2.getName()));
        restaurant3.setMenus(createMenus(restaurant3.getName()));
        restaurant4.setMenus(createMenus(restaurant4.getName()));

        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        restaurants.add(restaurant3);
        restaurants.add(restaurant4);

        return restaurants;
    }

    private static List<Menu> createMenus(String restaurant){
        List<Menu> menus = new ArrayList<>();
        Menu menu1 = new Menu("Lunch");
        Menu menu2 = new Menu("Dinner");

        menu1.setMenuItems(createMenuItem(restaurant));
        menu2.setMenuItems(createMenuItem(restaurant));

        menus.add(menu1);
        menus.add(menu2);

        return menus;
    }

    private static List<MenuItem> createMenuItem(String restaurant){
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Rice", 1.00));

        if(restaurant.equalsIgnoreCase("Sichuan Spicy")) {
            menuItems.add(new MenuItem("Spicy Beef", 9.99));
            menuItems.add(new MenuItem("Spicy Chicken", 6.99));
        }
        else if(restaurant.equalsIgnoreCase("Shanghai Family")){
            menuItems.add(new MenuItem("Sweet Rib", 9.99));
            menuItems.add(new MenuItem("Fish Soup", 12.99));
        }
        else if(restaurant.equalsIgnoreCase("Dongbei Food")){
            menuItems.add(new MenuItem("Fried Pork", 7.99));
            menuItems.add(new MenuItem("Chicken Mushroom", 12.99));
        }

        return menuItems;
    }


}
