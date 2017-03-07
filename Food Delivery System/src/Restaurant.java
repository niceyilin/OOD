import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yilin on 3/2/2017.
 */
public class Restaurant {
    private String name;
    private String addr;
    private String phone;
    private LocalTime opentime;
    private LocalTime closetime;
    private List<Menu> menus = new ArrayList<>();
    private List<Review> reviews = new ArrayList<>();

    public Restaurant(String name, String addr, String phone){
        this.name = name;
        this.addr = addr;
        this.phone = phone;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean isOpen(LocalTime t){
        return t.isAfter(opentime) && t.isBefore(closetime);
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public LocalTime getClosetime() {
        return closetime;
    }

    public LocalTime getOpentime() {
        return opentime;
    }

    public void setClosetime(LocalTime closetime) {
        this.closetime = closetime;
    }

    public void setOpentime(LocalTime opentime) {
        this.opentime = opentime;
    }
}
