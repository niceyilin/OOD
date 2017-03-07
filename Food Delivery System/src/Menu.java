import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yilin on 3/2/2017.
 */
public class Menu {
    private String menuName;
    private List<MenuItem> menuItems = new ArrayList<>();

    public Menu(String name){
        this.menuName = name;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void addMenuItems(MenuItem menuItems) {
        this.menuItems.add(menuItems);
    }

}
