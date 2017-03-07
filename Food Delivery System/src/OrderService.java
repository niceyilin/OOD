import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by Yilin on 3/4/2017.
 */
public class OrderService {
    private HashMap<String, Order> orderBook = new HashMap();

    public Order placeOrder(User user, List<MenuItem> menuItemList){
        System.out.println(String.format("Placing order for user %s with below dishes...", user.getName()));
        for(MenuItem menuItem : menuItemList)
            System.out.println("\t-> " + menuItem.getName());

        String unique_order_id = UUID.randomUUID().toString();
        Order order = new Order(unique_order_id);
        order.setOrderItems(createOrderItems(menuItemList));
        order.setOrderStatus(OrderStatus.CREATED);
        order.setDeliveryAddr(user.getAddr());

        orderBook.put(user.getName(), order);
        return order;
    }

    private List<OrderItem> createOrderItems(List<MenuItem> menuItemList){
        List<OrderItem> orderItems = new ArrayList();

        for(MenuItem menuitem : menuItemList){
            OrderItem newOrderItem = new OrderItem();
            newOrderItem.setDish(menuitem);
            orderItems.add(newOrderItem);
        }

        return orderItems;
    }

    public void updateOrderStatus(Order order, OrderStatus newStatus){
        order.setOrderStatus(newStatus);
    }

    public OrderStatus getOrderStatus(User user){
        System.out.println("Order Status is : " + orderBook.get(user.getName()).getOrderStatus().name());
        return orderBook.get(user.getName()).getOrderStatus();
    }

    public double getTotal(Order order){
        System.out.println("Order Total is $" + order.getTotal());
        return order.getTotal();
    }

}
