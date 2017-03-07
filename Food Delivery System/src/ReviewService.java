import java.util.HashMap;
import java.util.List;

/**
 * Created by Yilin on 3/2/2017.
 */
public class ReviewService {
    private HashMap<String, Review> reviewMap = new HashMap<>();

    public Review makeReview(User user, Restaurant restaurant, String title){
        System.out.println(String.format("Adding %s's review to restaurant %s...", user.getName(), restaurant.getName()));
        System.out.println("\t : " + title);

        Review review = new Review(title, user, restaurant);
        addReviewToRestaurant(restaurant, review);
        addReviewToUser(user, review);

        reviewMap.put(user.getName(), review);
        return review;
    }

    private void addReviewToRestaurant(Restaurant restaurant, Review review){
        restaurant.addReview(review);
    }

    private void addReviewToUser(User user, Review review){
        user.addReview(review);
    }

    public List<Review> getReviewByRestaurant(Restaurant restaurant){
        System.out.println(String.format("Reviews for restaurant %s : ", restaurant.getName()));
        for(Review review : restaurant.getReviews()){
            System.out.println("\t-> " + review.getTitle());
        }
        return restaurant.getReviews();
    }

    public List<Review> getReviewByUser(User user){
        System.out.println(String.format("Reviews made by %s : ", user.getName()));
        for(Review review : user.getReviews()){
            System.out.println("\t-> " + review.getTitle());
        }
        return user.getReviews();
    }

}
