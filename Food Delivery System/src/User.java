import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yilin on 3/2/2017.
 */
public class User {
    private String name;
    private String addr;
    private List<Review> reviews = new ArrayList<>();

    public User(String name, String addr){
        this.name = name;
        this.addr = addr;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public List<Review> getReviews(){
        return this.reviews;
    }

    public void addReview(Review new_review){
        reviews.add(new_review);
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
