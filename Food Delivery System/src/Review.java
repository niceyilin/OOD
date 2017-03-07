import java.time.LocalTime;

/**
 * Created by Yilin on 3/2/2017.
 */
public class Review {
    private String title;
    private String content;
    private User created_by;
    private Restaurant review_target;
    private int score;

    public Review(String title, User reviewer, Restaurant target){
        this.title = title;
        this.created_by = reviewer;
        this.review_target = target;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return this.content;
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return this.score;
    }

}
