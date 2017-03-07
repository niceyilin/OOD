import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yilin on 3/2/2017.
 */
public class MenuService {

    public List<MenuItem> queryMenu(Restaurant restaurant, String menuName){
        System.out.println(String.format("Querying %s Menu @ %s restaurant...", menuName, restaurant.getName()));

        List<MenuItem> menuItems = new ArrayList<>();
        for(Menu menu : restaurant.getMenus()){
            if(menu.getMenuName().equalsIgnoreCase(menuName)){
                menuItems.addAll(menu.getMenuItems());
            }
        }

        System.out.println(String.format("\tFound %d matching dishes :", menuItems.size()));
        for(MenuItem item : menuItems)
            System.out.println("\t\t-> " + item.getName() + ", price: $" + item.getPrice());

        return menuItems;
    }

}