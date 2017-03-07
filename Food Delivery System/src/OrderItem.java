/**
 * Created by Yilin on 3/3/2017.
 */
public class OrderItem {
    private MenuItem dish;
    private double price;
    private int amount;


    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public MenuItem getDish() {
        return dish;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDish(MenuItem dish) {
        this.price = dish.getPrice();
        this.dish = dish;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

