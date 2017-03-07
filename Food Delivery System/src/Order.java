import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yilin on 3/3/2017.
 */
public class Order {
    private String order_id;
    private String deliveryAddr;
    private LocalTime estimated_delivery_time;
    private List<OrderItem> orderItems = new ArrayList<>();
    private OrderStatus orderStatus;
    private double total;

    public Order(String order_id){
        total = 0.0;
        this.order_id = order_id;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        for(OrderItem orderItem : orderItems){
            this.total += orderItem.getPrice();
        }
        this.orderItems = orderItems;
    }

    public LocalTime getEstimated_delivery_time() {
        return estimated_delivery_time;
    }

    public String getDeliveryAddr() {
        return deliveryAddr;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setDeliveryAddr(String deliveryAddr) {
        this.deliveryAddr = deliveryAddr;
    }

    public void setEstimated_delivery_time(LocalTime estimated_delivery_time) {
        this.estimated_delivery_time = estimated_delivery_time;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
