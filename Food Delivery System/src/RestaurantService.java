import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yilin on 3/2/2017.
 */
public class RestaurantService {
    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantService(List<Restaurant> restaurants){
        this.restaurants = restaurants;
    }

    public void addRestaurant(Restaurant restaurant) {
        this.restaurants.add(restaurant);
    }

    public List<Restaurant> queryRestaurantByName(String name){
        System.out.println(String.format("Querying restaurant with name %s...", name));

        List<Restaurant> queryRes = new ArrayList<>();
        for(Restaurant restaurant : restaurants){
            if(restaurant.getName().contains(name)){
                queryRes.add(restaurant);
            }
        }

        System.out.println(String.format("\tFound %d matching restaurant :", queryRes.size()));
        for(Restaurant res : queryRes)
            System.out.println("\t\t-> " + res.getName());

        return queryRes;
    }
}
